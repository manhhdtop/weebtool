<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>

<!--::breadcrumb part start::-->
<section class="breadcrumb blog_bg">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 offset-lg-1 col-sm-8 offset-sm-2">
				<div class="breadcrumb_iner">
					<div class="breadcrumb_iner_item">
						<h2>Liên hệ</h2>
						<p>Nơi đón nhận thắc mắc, góp ý.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!--::breadcrumb part start::-->

<!-- ================ contact section start ================= -->
<section class="contact-section area-padding">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<h2 class="contact-title">Gửi mail</h2>
			</div>
			<div class="col-lg-8">
				<form class="form-contact contact_form" action="contact_process.php"
					method="post" id="contactForm" novalidate="novalidate">
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<input class="form-control placeholder hide-on-focus"
									name="name" id="name" type="text" placeholder="Nhập Họ Tên...">
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<input class="form-control placeholder hide-on-focus"
									name="email" id="email" type="email"
									placeholder="Nhập Email...">
							</div>
						</div>
						<div class="col-12">
							<div class="form-group">
								<input class="form-control placeholder hide-on-focus"
									name="subject" id="subject" type="text"
									placeholder="Nhập tiêu đề...">
							</div>
						</div>
						<div class="col-12">
							<div class="form-group">
								<textarea class="form-control w-100 placeholder hide-on-focus"
									name="message" id="message" cols="30" rows="9"
									placeholder="Nhập nội dung..."></textarea>
							</div>
						</div>
					</div>
					<div class="form-group mt-3">
						<button type="submit" class="button button-contactForm">
							<i class="far fa-paper-plane"> </i> Gửi mail
						</button>
					</div>
				</form>
			</div>
			<div class="col-lg-4">
				<div class="media contact-info">
					<span class="contact-info__icon"><i class="ti-email"></i></span>
					<div class="media-body">
						<h3>
							<a href="mailto:hoangmanh1505@gmail.com">hoangmanh1505@gmail.com</a>
						</h3>
						<p>Gửi thắc mắc, góp ý bất kỳ lúc nào!</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- ================ contact section end ================= -->

<%@ include file="layout/footer.jsp"%>