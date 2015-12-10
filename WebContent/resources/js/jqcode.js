$(document)
		.ready(
				function() {
					
					var heading="";
					$(document).on('focusout', '#HeadingDetail', function() {
						heading = $("#HeadingDetail").val();
					});

					$(document).on('focusin', '#SubHeadingDetail', function() {
						$.ajax({
							url : "rest/heading/getvalue/" +heading,
							type : 'GET',
							dataType : "json",
							success : function(data) {
								$('#SubHeadingDetail').empty();
								var json = eval(data);
								for (var i = json.length - 1; i >= 0; i--) {
									$('#SubHeadingDetail')
											.append(
													'<option value="'+json[i]+'">'
															+ json[i]
															+ '</option>');
								}
							}
						});

					});
					
					$(document).on('click', '#register', function() {
						$("#registerform").dialog({
							title : 'Register',
							modal : true,
							resizable : false,
							width : 500,
							height : 550,
							closeText : 'close',
							draggable : false,
							show : 'fade',
							hide : 'fade',
							dialogClass : 'main-dialog-class'
						});
					});

					
					
					$('#username').focusout(function() {
						if ($('#username').val() == "") {
							$('#spanuser').text("Enter User Name");
							if ($('#password').val() == "")
								$('#loginsubmit').hide();
						} else {
							$('#spanuser').text("");
							$('#loginsubmit').show();
						}
					});

					$('#password').focusout(function() {
						if ($('#password').val() == "") {
							$('#spanpassword').text("Enter Password");
							if ($('#username').val() == "")
								$('#loginsubmit').hide();
						} else {
							$('#spanpassword').text("");
							$('#loginsubmit').show();
						}
					});

					$('#firstname').focusout(function() {
						if ($('#firstname').val() == "")
							$('#spanfname').text("Enter First Name");
						else
							$('#spanfname').text("");
					});

					$('#lastname').focusout(function() {
						if ($('#lastname').val() == "")
							$('#spanlname').text("Enter Last Name");
						else
							$('#spanlname').text("");
					});

					$('#contact').focusout(function() {
						if ($('#contact').val() == "")
							$('#spancontact').text("Enter Contact Number");
						else
							$('#spancontact').text("");

					});
					$('#contact').keyup(
							function() {
								var contactLength = $('#contact').val().length;
								if (contactLength <= 10) {
									$('#spancontact').text("");
								} else {
									$('#spancontact').text(
											"Contact digit is more than 10");

								}
							});

					$('#email')
							.focusout(
									function() {
										if ($('#email').val() == "")
											$('#spanemail').text(
													"Enter Email-Id");
										else
											$('#spanemail').text("");

										var emailValid = $('#email').val();
										var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
										if (!filter.test(emailValid)) {

											$('#spanemail').text(
													"Enter Valid  Email-ID");
										} else {

											$('#spanemail').text("")
										}

									});

					$('#regusername').focusout(function() {
						if ($('#regusername').val() == "")
							$('#spanregusername').text("Enter UserName");
						else
							$('#spanregusername').text("");

					});

					$('#regpassword').focusout(function() {
						if ($('#regpassword').val() == "")
							$('#spanregpassword').text("Enter Password");
						else
							$('#spanregpassword').text("");
					});

					$('#regusername')
							.keyup(
									function() {
										var usernameLength = $('#regusername')
												.val().length;
										if (usernameLength < 15) {
											$('#spanregusername').text("");
										} else {
											$('#spanregusername')
													.text(
															"Not exceeded than 15 characters");

										}
									});

					$('#regpassword')
							.keyup(
									function() {
										var passwordLength = $('#regpassword')
												.val().length;
										// $('#userName').text(userNameLength);
										if (passwordLength <= 10
												&& passwordLength >= 4) {
											$('#spanregpassword').text("");
										} else {
											$('#spanregpassword')
													.text(
															"Password range is between 4 -10");

										}

										var passwordValid = $('#regpassword')
												.val();
										var regex = /^[a-zA-Z0-9]+$/;
										if (regex.test(passwordValid)) {
											$('#spanregpassword')
													.text(
															"Password Contains Alphanumeric and Special Charcters");

										} else {
											$('#spanregpassword').text("")

										}

									});

					$('#email')
							.keyup(
									function() {
										var emailValid = $('#email').val();
										var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
										if (!filter.test(emailValid)) {

											$('#spanemail').text(
													"Enter Valid  Email-ID");
										} else {

											$('#spanemail').text("")
										}

									});

					$(function() {
						$("#tabmenu").tabs({
							height : 150,
						});
					});

					$(function() {
						$("#coursestabmenu").tabs();
					});

				});
