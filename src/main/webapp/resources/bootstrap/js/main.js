$(document).ready(function () {
    $("#menu").on("click", "a", function (a) {
        a.preventDefault();
        var b = $(this).attr("href"), c = $(b).offset().top;
        $("body,html").animate({scrollTop: c}, 1500)
    }), $("#menu_bottom").on("click", "a", function (a) {
        a.preventDefault();
        var b = $(this).attr("href"), c = $(b).offset().top;
        $("body,html").animate({scrollTop: c}, 1500)
    }), $(".main").appear({force_process: !0}), $(".categories").appear({force_process: !0}), $(".products").appear({force_process: !0}), $(".delivery").appear({force_process: !0}), $(".payments").appear({force_process: !0}), $(".contacts").appear({force_process: !0}), $(document.body).on("appear", "#label-main", function () {
        $("#label-main").addClass("animated zoomIn")
    }), $("#label-main").appear({force_process: !0}), $(document.body).on("appear", "#label-products", function () {
        $("#label-products").addClass("animated zoomIn")
    }), $("#label-products").appear({force_process: !0}), $(document.body).on("appear", "#label-category", function () {
        $("#label-category").addClass("animated zoomIn")
    }), $("#label-category").appear({force_process: !0}), $(document.body).on("appear", "#label-delivery", function () {
        $("#label-delivery").addClass("animated zoomIn")
    }), $("#label-delivery").appear({force_process: !0}), $(document.body).on("appear", "#label-payments", function () {
        $("#label-payments").addClass("animated zoomIn")
    }), $("#label-payments").appear({force_process: !0}), $(document.body).on("appear", "#label-cantacts", function () {
        $("#label-cantacts").addClass("animated zoomIn")
    }), $("#label-cantacts").appear({force_process: !0}), $(document.body).on("appear", "#icon1", function () {
        $("#icon1").addClass("animated bounce")
    }), $("#icon1").appear({force_process: !0}), $(document.body).on("appear", "#icon2", function () {
        $("#icon2").addClass("animated bounce")
    }), $("#icon2").appear({force_process: !0}), $(document.body).on("appear", "#icon3", function () {
        $("#icon3").addClass("animated bounce")
    }), $("#icon3").appear({force_process: !0}), $(document.body).on("appear", "#icon4", function () {
        $("#icon4").addClass("animated bounce")
    }), $("#icon4").appear({force_process: !0}), $(document.body).on("appear", "#icon5", function () {
        $("#icon5").addClass("animated bounce")
    }), $("#icon5").appear({force_process: !0}), $(document.body).on("appear", "#icon6", function () {
        $("#icon6").addClass("animated bounce")
    }), $("#icon6").appear({force_process: !0})
});