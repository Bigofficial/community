$(function(){
	$("#publishBtn").click(publish);
});

function publish() {
	$("#publishModal").modal("hide");

	//获取标题 内容
	var title = $("#recipient-name").val();
	var content = $("#message-text").val();
	console.log(title);
	console.log(content);
	//发送异步请求
	$.post(
		CONTEXT_PATH + "/discuss/add",
		{"title":title, "content":content},
		function (data){
			data = $.parseJSON(data);
			//在提示框显示返回消息
			$("hintBody").text(data.msg);
			//显示提示框两秒自动关闭
			$("#hintModal").modal("show");
			setTimeout(function(){
				$("#hintModal").modal("hide");
				//刷新页码
				if(data.code == 0){
					window.location.reload();
				}
			}, 2000);
		}
	)


}