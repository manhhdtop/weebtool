var usernameAttr = 0;
var passwordAttr = 0;

$('#username').click(function()
{
	removeUsernameAttr();
}).focusout(function()
{
	addUsernameAttr();
})

$('#password').click(function()
{
	removePasswordAttr();
}).focusout(function()
{
	addPasswordAttr();
})

function addUsernameAttr()
{
	if (usernameAttr == 0)
	{
		$('#username').prop('pattern', "[A-Za-z][A-Za-z0-9.\-]{3,20}");
		$('#username').prop('required', true);
		usernameAttr = 1;
	}
	if ($('#username').is(":valid"))
	{
		$('#username').prop("title", "Username bao gồm chữ, số, các ký tự '-.'; độ dài 4-20 ký tự.");
	}
}

function removeUsernameAttr()
{
	if (usernameAttr == 1)
	{
		$('#username').removeAttr('pattern');
		$('#username').removeAttr('required');
		usernameAttr = 0;
	}
}

function addPasswordAttr()
{
	if (passwordAttr == 0)
	{
		$('#password').prop('pattern', "[A-Za-z0-9]{6,50}");
		$('#password').prop('required', true);
		$('#password').prop("title", "Password bao gồm chữ và số độ dài 6-50 ký tự.");
		passwordAttr = 1;
	}
	if ($('#password').is(":valid"))
	{
		$('#password').prop("title", "Username bao gồm chữ, số, các ký tự '-.'; độ dài 4-20 ký tự.");
	}
}

function removePasswordAttr()
{
	if (passwordAttr == 1)
	{
		$('#password').removeAttr('pattern');
		$('#password').removeAttr('required');
		passwordAttr = 0;
	}
}
$(function()
{
	$('#login').click(function(e)
	{
		// Prevent default submission of form
		e.preventDefault();
		
		$('#loginError').html('');
		$('#loginError').hide();
		
		addUsernameAttr();
		addPasswordAttr();
		var valid = true;
		if (!$('#username').is(":valid"))
		{
			$('#usernameError').html('Username không hợp lệ!');
			$('#usernameError').show();
			valid = false;
		}
		else
		{
			$('#usernameError').html('');
			$('#username').removeAttr('title');
			$('#usernameError').hide();
		}
		if (!$('#password').is(":valid"))
		{
			$('#passwordError').html('Password không hợp lệ!');
			$('#passwordError').show();
			valid = false;
		}
		else
		{
			$('#passwordError').html('');
			$('#password').removeAttr('title');
			$('#passwordError').hide();
		}
		
		if (valid)
		{
			$.post({
			    type : "POST",
			    data : {
			        username : $('#username').val(),
			        password : $('#password').val()
			    },
			    url : "/do-login",
			    timeout : 100000,
			    success : function(res)
			    {
				    console.log(res);
				    $('#loginError').html('Login success!');
				    $('#loginError').show();
			    },
			    error : function(res)
			    {
				    console.log(res);
				    $('#loginError').html('Login error!');
				    $('#loginError').show();
			    }
			})
		}
	})
})