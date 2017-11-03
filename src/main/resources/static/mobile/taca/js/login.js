/**
 * Created by 芳华 on 2017/10/10.
 */
function login() {
    var username=document.getElementById("username").value;
    var password=document.getElementById("password").value;
    $.ajax({
        type:'GET',
        url:'../../mobile/rest/login/vertify',
        dataType:"json",
        async:true,
        data:{
            "username":username,
            "password":password
        },
        success:function (data) {
            if(data.code=='000000'){
                window.location.href='../mobile/notice/list';
            }
            else{
                $("#result").html(data.message);
            }
        }
    });
}
