$(document).ready(function()
{
	(function($)
	{
		"use strict";

		jQuery.validator.addMethod('answercheck', function(value, element)
		{
			return this.optional(element) || /^\bcat\b$/.test(value)
		}, "type the correct answer -_-");

		// validate contactForm form
		$(function()
		{
			$('#contactForm').validate({
			    rules : {
			        name : {
			            required : true,
			            minlength : 2
			        },
			        subject : {
			            required : true,
			            minlength : 4
			        },
			        email : {
			            required : true,
			            email : true
			        },
			        message : {
			            required : true,
			            minlength : 20
			        }
			    },
			    messages : {
			        name : {
			            required : "Bạn vui lòng để lại tên...",
			            minlength : "Tên quá ngắn."
			        },
			        subject : {
			            required : "Bạn vui lòng nhập tiêu đề...",
			            minlength : "Tiêu đề không hợp lệ."
			        },
			        email : {
				        required : "Bạn vui lòng nhập email..."
			        },
			        message : {
			            required : "Bạn vui lòng nhập nội dung...",
			            minlength : "Đây là tất cả nội dung?"
			        }
			    },
			    submitHandler : function(form)
			    {
				    $(form).ajaxSubmit({
				        type : "POST",
				        data : $(form).serialize(),
				        url : "contact_process.php",
				        success : function()
				        {
					        $('#contactForm :input').attr('disabled', 'disabled');
					        $('#contactForm').fadeTo("slow", 1, function()
					        {
						        $(this).find(':input').attr('disabled', 'disabled');
						        $(this).find('label').css('cursor', 'default');
						        $('#success').fadeIn()
						        $('.modal').modal('hide');
						        $('#success').modal('show');
					        })
				        },
				        error : function()
				        {
					        $('#contactForm').fadeTo("slow", 1, function()
					        {
						        $('#error').fadeIn()
						        $('.modal').modal('hide');
						        $('#error').modal('show');
					        })
				        }
				    })
			    }
			})
		})

	})(jQuery)
})