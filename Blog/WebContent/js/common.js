window.onload = function(){
	$(".connect p").eq(0).animate({"left":"0%"}, 600);
	$(".connect p").eq(1).animate({"left":"0%"}, 400);
};

$(document).ready(function(){
	$("#loginForm").validate({
		rules:{
			username:{
				required:true,
				minlength:3, 
				maxlength:32,
			},
			password:{
				required:true,
				minlength:3, 
				maxlength:32,
			},
		},
		messages:{
			username:{
				required:"User name required",
				minlength:"At least 3 characters",
				maxlength:"At most 32 characters",
				remote: "User name already exist",
			},
			password:{
				required:"Password Required",
				minlength:"At least 3 characters",
				maxlength:"At most 32 characters",
			},
		},

	});
	
	$("#registerForm").validate({
		rules:{
			username:{
				required:true,
				minlength:3, 
				maxlength:32,
				remote:{
					url:"http://localhost:8080/Final/UserName",
					type:"post",
				},
			},
			password:{
				required:true,
				minlength:3, 
				maxlength:32,
			},
			email:{
				required:true,
				email:true,
			},
			confirm_password:{
				required:true,
				minlength:3,
				equalTo:'.password'
			},
		},
		messages:{
			username:{
				required:"User name required",
				minlength:"At least 3 characters",
				maxlength:"At most 32 characters",
				remote: "User name already exist",
			},
			password:{
				required:"Password Required",
				minlength:"At least 3 characters",
				maxlength:"At most 32 characters",
			},
			email:{
				required:"Enter e-mail address",
				email: "E-mail address not vaild"
			},
			confirm_password:{
				required: "Please enter password again",
				minlength: "At least 3 characters",
				equalTo: "Confirm password not correct",
			},
		
		},
	});
	
	$("#personalInfoForm").validate({
		rules:{
			firstname:{
				maxlength:20,
			},
			password:{
				maxlength:20,
			},
			birthday:{
				dateISO:true,
			},
			briefIntro:{
				maxlength:255,
			},
			personalizedSignature:{
				maxlength:100,
			},
		},
		messages:{
			username:{
				maxlength:"At most 20 characters",
			},
			password:{
				maxlength:"At most 20 characters",
			},
			birthday:{
				dateISO:"Please enter a valid date",
			},
			briefIntro:{
				maxlength:"At most 255 characters",
			},
			personalizedSignature:{
				maxlength:"At most 100 characters", 
			},
		},
	}); 
	
	$("#blogForm").validate({
		rules:{
			title:{
				required:true,
				maxlength:50,
			},
			context:{
				required:true,
				maxlength:65535,
			},
		},
		messages:{
			title:{
				required:"Title required",
				maxlength:"At most 50 characters",
			},
			context:{
				required:"Context required",
				maxlength:"At most 65535 characters",
			},
		},
	}); 
	
	$("#commentForm").validate({
		rules:{
			comment:{
				required:true,
				maxlength:255,
			},
		},
		messages:{
			comment:{
				required:"Context required",
				maxlength:"At most 255 characters",
			},
		},
	}); 
	
	$("#messageForm").validate({
		rules:{
			to:{
				required:true,
			},
			title:{
				required:true,
				maxlength:50,
			},
			context:{
				required:true,
				maxlength:65535,
			},
		},
		messages:{
			to:{
				required:"Receiver name required",
			},
			title:{
				required:"Title required",
				maxlength:"At most 50 characters",
			},
			context:{
				required:"Context required",
				maxlength:"At most 65535 characters",
			},
		},
	}); 
	
});
