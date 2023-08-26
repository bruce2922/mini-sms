

    $(function (){

    loadStuList();

    loadCategoryList();

    loadStuDetail();

    /**
     *  clear student detail
     */
    $('#stuDetailModal').on('hide.bs.modal', function (e){

    $("#stuId").text("");
    $("#stuNumber").text("");
    $(':input','#stuForm')
    .not(':button, :submit, :reset, :hidden')
    .val('')
    .removeAttr('checked')
    .removeAttr('selected');
    $(".alert").hide();
})


    initDatepicker('#bdDatepicker');
    initDatepicker('#sdDatepicker');
    initDatepicker('#ldDatepicker');

    /**
     *  save student
     */
    $("#saveBtn").on("click",function(){
    let stuId = $(this).attr("stu-id");
    saveStu(stuId);
})


})

    function loadStuList(pageNo){
    pageNo = pageNo || 1;
    $.ajax({
    type:"get",
    async:true,
    url:getRequestPath("student/list/"+pageNo),
    dataType:"json",
    error: function(e){
    console.log("student data loading error" + e);
},
    success: function(jData){
    let pageData = jData.data;
    let pageIndex = pageData.pageIndex;

    /**
     *  student list data
     */
    let stuList = pageData.dataList;
    if(stuList.length > 0){
    let template = $("#stuListTemplate").html();
    let content = Mustache.render(template, {items:stuList});
    $("#stuList").empty();
    $("#stuList").append(content);
}

    /**
     *  pagination init
     *
     */
    let cc = '';
    let isActive = '';

    for(var i=0; i<pageData.totalPage; i++){
    let pageNo = i+1;
    if(pageNo == pageIndex){
    isActive = 'active';
}else{
    isActive = '';
}
    cc += '<li class="page-item '+ isActive +'"><a class="page-link" href="#" onclick="loadStuList('+pageNo+')">'+pageNo+'</a></li>';
}

    $("#pagination").empty();
    $("#pagination").append(cc);


    /**
     *  enable tooltip
     */
    $('[data-toggle="tooltip"]').tooltip();

},beforeSend:function(){
    $("#loadIcon").show();
},complete:function(){
    $("#loadIcon").hide();
}
})
}

    function loadCategoryList(){
    $.ajax({
        type: "get",
        async: true,
        url: getRequestPath("category/list"),
        dataType: "json",
        error: function (e) {
            console.log("category data loading error" + e);
        },
        success: function (jData) {
            let categoryList = jData.data;

            $.each(categoryList, function (i, item) {
                let option = "<option value='" + item.id + "'>" + item.name + "</option>";
                $("#category").append(option);
            });

        }
    })
}

    function initDatepicker(id){
    $(id).datepicker({
        uiLibrary: 'bootstrap4',
        format: 'dd/mm/yyyy',
        modal: true
    });
}

    function loadStuDetail() {
    $('#stuDetailModal').on('show.bs.modal', function (e) {

        let stuId = $(e.relatedTarget).attr("stu-id");
        $("#saveBtn").attr("stu-id", stuId);
        if (stuId == 0) { // new student
            $.ajax({
                type: "get",
                async: true,
                url: getRequestPath("contact/list"),
                dataType: "json",
                error: function (e) {
                    console.log("contact list loading error" + e);
                },
                success: function (jData) {
                    let contactList = jData.data;

                    if (contactList.length > 0) {
                        $("#contactList").empty();
                        let template = $("#stuContactListTemplate").html();
                        let content = Mustache.render(template, {items: contactList});
                        $("#contactList").append(content);
                    }
                }
            })
        } else { // old student
            $.ajax({
                type: "get",
                async: true,
                url: getRequestPath("student/info/" + stuId),
                dataType: "json",
                error: function (e) {
                    console.log("student detail loading error" + e);
                },
                success: function (jData) {
                    let stuData = jData.data;
                    let contactList = stuData.contactList;

                    $("#stuId").text(stuData.id);
                    $("#stuNumber").text(stuData.studentNumber);
                    $("#stuName").val(stuData.name);
                    //$("#gender").find("option:selected").text(stuData.gender); //TODO
                    $("form").find("input[name='birthDate']").val(stuData.birthDate);
                    $("form").find("input[name='address']").val(stuData.address);
                    // $("form input[name='category']"); //TODO


                    $("form").find("input[name='startingDate']").val(stuData.startingDate);
                    $("form").find("input[name='leavingDate']").val(stuData.leavingDate);

                    if (contactList.length > 0) {
                        $("#contactList").empty();
                        let template = $("#stuContactListTemplate").html();
                        let content = Mustache.render(template, {items: contactList});
                        $("#contactList").append(content);
                    }

                }
            })
        }

    })
}

    function saveStu(stuId){
    let requestUrl = getRequestPath("student/info");
    let requestType = "post";
    if(stuId > 0){
    requestType = "put";
}

    let requestData = $("#stuForm").serializeJSON();
    requestData['id'] = stuId;
    let contactArray = new Array();
    /**
     * To get checked contact individually
     */
    $("input[name='contactList']:checked").each(function (index, item) {
    contactArray.push(item.value);
});
    requestData['contactList'] = contactArray;

    $.ajax({
    type:requestType,
    async:true,
    url:requestUrl,
    data:JSON.stringify(requestData),
    contentType:"application/json",
    dataType:"json",
    error: function(e){
    failedAlert();
    console.log("save student detail error" + e);
},
    success: function(jData){
    successAlert();
}
})
}

    function removeStu(id){

    $.ajax({
        type: "delete",
        async: true,
        url: getRequestPath("student/" + id),
        contentType: "application/json",
        dataType: "json",
        error: function (e) {
            console.log("remove student error" + e);
        },
        success: function (jData) {
            loadStuList();
        }
    })
}

    function successAlert(){
    $(".alert-success").slideDown();
}

    function failedAlert(){
    $(".alert-danger").slideDown();
}
