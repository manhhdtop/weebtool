<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--::footer_part start::-->
<footer class="footer_part">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="footer_logo">
					<a href="/" class="footer_logo_iner"> <img class="logo-img"
						src="img/footer_logo.png" alt="#">
					</a>
				</div>
			</div>

			<div class="col-sm-6 col-lg-3">
				<div class="single_footer_part">
					<h4>About</h4>
					<p>Chia sẻ kiến thức, kinh nghiệm về lập trình.</p>
					<div class="footer_icon social_icon">
						<ul class="list-unstyled">
							<li><a href="https://www.fb.com/hoang.manh.155"
								class="single_social_icon" target="_blank"><i
									class="fab fa-facebook-f"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-sm-6 col-lg-3">
				<div class="single_footer_part">
					<h4>Thông tin liên hệ</h4>
					<p>Họ tên: Hoàng Đức Mạnh</p>
					<p>Số điện thoại : 0929 255 410</p>
					<p>Email : hoangmanh1505@gmail.com</p>
				</div>
			</div>
			<div class="col-sm-6 col-lg-3">
				<div class="single_footer_part">
					<h4>Important Link</h4>
					<ul class="list-unstyled">
						<li><a href=""> WHMCS-bridge</a></li>
						<li><a href="">Search Domain</a></li>
						<li><a href="">My Account</a></li>
						<li><a href="">Shopping Cart</a></li>
						<li><a href="">Our Shop</a></li>
					</ul>
				</div>
			</div>
			<div class="col-sm-6 col-lg-3">
				<div class="single_footer_part">
					<h4>Newsletter</h4>
					<p>Heaven fruitful doesn't over lesser in days. Appear creeping
						seasons deve behold bearing days open</p>
					<div id="mc_embed_signup">
						<form target="_blank"
							action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
							method="get" class="subscribe_form relative mail_part">
							<input type="email" name="email" id="newsletter-form-email"
								placeholder="Email Address" class="placeholder hide-on-focus"
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Email Address '" required
								type="email">
							<button type="submit" name="submit" id="newsletter-submit"
								class="email_icon newsletter-submit">
								<i class="far fa-paper-plane"></i>
							</button>
							<div class="mt-10 info"></div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-lg-12">
				<div class="copyright_text text-center">
					<p>
						Copyright &copy;
						<jsp:useBean id="date" class="java.util.Date" />
						<fmt:formatDate value="${date}" pattern="yyyy" />
						All rights reserved
					</p>
				</div>
			</div>
		</div>
	</div>
	<a class="goToTop"><i
		class="fas fa-2x fa-arrow-up alert alert-secondary"></i></a>
</footer>
<!--::footer_part end::-->

<!-- jquery plugins here-->
<script src="js/jquery-1.12.1.min.js"></script>
<!-- popper js -->
<script src="js/popper.min.js"></script>
<script src="js/slick.min.js"></script>
<!-- bootstrap js -->
<script src="js/bootstrap.min.js"></script>
<!-- magnific js -->
<script src="js/jquery.magnific-popup.min.js"></script>
<!-- carousel js -->
<script src="js/owl.carousel.min.js"></script>
<!-- easing js -->
<script src="js/jquery.easing.min.js"></script>
<!--masonry js-->
<script src="js/masonry.pkgd.min.js"></script>
<script src="js/masonry.pkgd.js"></script>
<!--form validation js-->
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/contact.js"></script>
<script src="js/jquery.ajaxchimp.min.js"></script>
<script src="js/jquery.form.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/mail-script.js"></script>
<!-- counter js -->
<script src="js/jquery.counterup.min.js"></script>
<script src="js/waypoints.min.js"></script>
<!-- custom js -->
<script src="js/custom.js"></script>

</body>

</html>