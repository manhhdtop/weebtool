    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" %>
        <%@ include file="template/header.jsp" %>

        <!--::breadcrumb part start::-->
        <section class="breadcrumb blog_bg">
        <div class="container">
        <div class="row">
        <div class="col-lg-6 offset-lg-1 col-sm-8 offset-sm-2">
        <div class="breadcrumb_iner">
        <div class="breadcrumb_iner_item">
        <h2>Tool</h2>
        <p>Một số tool tiện ích.</p>
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
        <img class="card-img rounded-0" src="img/tool-banner.png" alt="">
        <span class="blog_item_date">
        <h3>15</h3>
        <p>Jan</p>
        </span>
        </div>

        <div class="blog_details">
        <a class="d-inline-block" href="single-blog.html">
        <h2>Công cụ chuyển đổi Timestamp</h2>
        </a>
        <p>Công cụ chuyển đổi Timestamp & Date.</p>
        <ul class="blog-info-link">
        <li><i class="fas fa-stream"></i> Timestamp by Takatori</li>
        <li><i class="fas fa-history"></i> 3 lượt</li>
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
        <h4 class="widget_title">Tools</h4>
        <ul class="list cat-list">
        <li><a href="#" class="d-flex">
        <p>Timestamp</p>
        </a></li>
        <li><a href="#" class="d-flex">
        <p>Calculate Date</p>
        </a></li>
        </ul>
        </aside>

        <aside class="single_sidebar_widget newsletter_widget">
        <h4 class="widget_title">Newsletter</h4>

        <form action="#">
        <div class="form-group">
        <input type="email"
        class="form-control placeholder hide-on-focus"
        placeholder="Enter email" required>
        </div>
        <button class="button rounded-0 primary-bg text-white w-100"
        type="submit">Subscribe</button>
        </form>
        </aside>
        </div>
        </div>
        </div>
        </div>
        </section>
        <!--================Blog Area =================-->

        <%@ include file="template/footer.jsp" %>