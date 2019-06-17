<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="template/header.jsp"%>

<!--::breadcrumb part start::-->
<section class="breadcrumb blog_bg">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 offset-lg-1 col-sm-8 offset-sm-2">
				<div class="breadcrumb_iner">
					<div class="breadcrumb_iner_item">
						<h2>${category.name }</h2>
						<p>${category.discription }</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!--::breadcrumb part start::-->


<!--================Blog Area =================-->
<section class="blog_area area-padding">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 mb-5 mb-lg-0">
				<div class="blog_left_sidebar">
					<article class="blog_item">
						<div class="blog_item_img">
							<img class="card-img rounded-0" src="/resource/img/post/java.jpeg" alt="">
							<span class="blog_item_date">
								<h3>15</h3>
								<p>May</p>
							</span>
						</div>

						<div class="blog_details">
							<a class="d-inline-block" href="single-blog.html">
								<h2>Hướng dẫn cài đặt java</h2>
							</a>
							<p>Hướng dẫn chi tiết cài đặt jdk, JAVA_HOME và tạo một
								project hello world.</p>
							<ul class="blog-info-link">
								<li><a href="#"><i class="fas fa-stream"></i> Java Core
								</a></li>
								<li><a href="#"><i class="far fa-comments"></i> 03
										Comments</a></li>
							</ul>
						</div>
					</article>

					<!-- Pagination -->
					<nav class="blog-pagination justify-content-center d-flex">
						<ul class="pagination">
							<li class="page-item"><a href="#" class="page-link"
								aria-label="Previous"> <i class="ti-angle-left"></i>
							</a></li>
							<li class="page-item"><a href="#" class="page-link">1</a></li>
							<li class="page-item active"><a href="#" class="page-link">2</a>
							</li>
							<li class="page-item"><a href="#" class="page-link"
								aria-label="Next"> <i class="ti-angle-right"></i>
							</a></li>
						</ul>
					</nav>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="blog_right_sidebar">
					<aside class="single_sidebar_widget search_widget">
						<form action="#">
							<div class="form-group">
								<div class="input-group mb-3">
									<input type="text"
										class="form-control placeholder hide-on-focus"
										placeholder="Nhập từ khóa...">
									<div class="input-group-append">
										<button class="btn" type="button">
											<i class="ti-search"></i>
										</button>
									</div>
								</div>
							</div>
							<button class="button rounded-0 primary-bg text-white w-100"
								type="submit">Tìm kiếm</button>
						</form>
					</aside>

					<aside class="single_sidebar_widget post_category_widget">
						<h4 class="widget_title">Category</h4>
						<ul class="list cat-list">
							<li><a href="html" class="d-flex">
									<p>
										<span>HTML</span><span>(37)</span>
									</p>
							</a></li>
							<li><a href="#" class="d-flex">
									<p>CSS</p>
									<p>(10)</p>
							</a></li>
							<li><a href="#" class="d-flex">
									<p>Java</p>
									<p>(03)</p>
							</a></li>
							<li><a href="#" class="d-flex">
									<p>Android</p>
									<p>(11)</p>
							</a></li>
							<li><a href="#" class="d-flex">
									<p>C#</p>
									<p>(21)</p>
							</a></li>
							<li><a href="#" class="d-flex">
									<p>Kotlin</p>
									<p>09</p>
							</a></li>
						</ul>
					</aside>

					<aside class="single_sidebar_widget tag_cloud_widget">
						<h4 class="widget_title">Tag Clouds</h4>
						<ul class="list">
							<li><a href="#">project</a></li>
							<li><a href="#">love</a></li>
							<li><a href="#">technology</a></li>
							<li><a href="#">travel</a></li>
							<li><a href="#">restaurant</a></li>
							<li><a href="#">life style</a></li>
							<li><a href="#">design</a></li>
							<li><a href="#">illustration</a></li>
						</ul>
					</aside>

					<aside class="single_sidebar_widget newsletter_widget">
						<h4 class="widget_title">Đăng ký nhận tin tức mới</h4>

						<form action="#">
							<div class="form-group">
								<input type="email"
									class="form-control placeholder hide-on-focus"
									placeholder="Nhập email" required>
							</div>
							<button class="button rounded-0 primary-bg text-white w-100"
								type="submit">Đăng ký</button>
						</form>
					</aside>
				</div>
			</div>
		</div>
	</div>
</section>
<!--================Blog Area =================-->


<%@ include file="template/footer.jsp"%>
