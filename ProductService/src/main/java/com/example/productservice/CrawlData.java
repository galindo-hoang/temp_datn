package com.example.productservice;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Data
@RequiredArgsConstructor
class Drug {
    Integer id = 0;
    String drugName;
    String image;
    String dosageForm;
    String indications;
    String contraindications;
    String interactions;
    String sideEffects;
    String expiredDate;
    Integer manufactureId;
    Integer categoryId;
}

@Data
@RequiredArgsConstructor
class Manufacture {
    Integer id = 0;
    String name;
    String address;
    String phoneNumber;
}

@Data
@RequiredArgsConstructor
class Ingredient {
    Integer id;
    String name;
}

@Data
@RequiredArgsConstructor
class IngredientDrug {
    Integer id;
    Integer drugId;
    Integer ingredientId;
    String unit;
    Integer numberUnit;
}

@Data
@RequiredArgsConstructor
class Category {
    Integer id;
    String name;
}

public class CrawlData {
    public static void main (String[] args) {
        ArrayList<Drug> drugArrayList = new ArrayList<>();
        ArrayList<Ingredient> ingredientArrayList = new ArrayList<>();
        ArrayList<IngredientDrug> ingredientDrugArrayList = new ArrayList<>();
        ArrayList<Manufacture> manufactureArrayList = new ArrayList<>();
        ArrayList<Category> categoryArrayList = new ArrayList<>();

        WebDriverManager.chromedriver().setup();


        WebDriver getPage = new ChromeDriver();
        getPage.get("https://nhathuoclongchau.com/thuoc/mat/cac-thuoc-nhan-khoa-khac");
        String name = getPage.findElement(By.xpath("//h1[@class=\"u-flex align-items-center fs-p-20 fs-p-md-16 txt-gray-800 title-product-highlight\"]")).getText();
        System.out.println("name: " + name);
        List<WebElement> more = getPage.findElements(By.xpath("//a[@data-type=\"productBestSeller\"]"));
        while (more.size() > 0) {
            System.out.println("------"+more.get(0).getAttribute("style"));
            if(!more.get(0).getAttribute("style").equals("display: none;")) {
                more.get(0).click();
                more = getPage.findElements(By.xpath("//a[@data-type=\"productBestSeller\"]"));
            }else break;
            getPage.manage().timeouts().implicitlyWait(2, TimeUnit.M);
        }

        List<String> rows = new ArrayList<>();
//        rows.add("https://nhathuoclongchau.com/thuoc/thuoc-khang-sinh-duong-toan-than");
//        rows.add("https://nhathuoclongchau.com/thuoc/he-tim-mach-and-tao-mau");
//        rows.add("https://nhathuoclongchau.com/thuoc/di-ung-and-he-mien-dich");
//        rows.add("https://nhathuoclongchau.com/thuoc/thuoc-da-lieu");
//        rows.add("https://nhathuoclongchau.com/thuoc/mat");
//        rows.add("https://nhathuoclongchau.com/thuoc/he-co-xuong");
//        rows.add("https://nhathuoclongchau.com/thuoc/vitamin-and-khoang-chat");
//        rows.add("https://nhathuoclongchau.com/thuoc/tai-and-mieng-hong");

//        rows.forEach(row -> {
//            WebDriver getPage = new ChromeDriver();
//            getPage.get(row);
//            List<String> cates = getPage.findElement(By.xpath("//div[@class=\"row reset-row cate-lv2-list cate-lv2-list-children relative p-t-md-12\"]"))
//                    .findElements(By.cssSelector("a"))
//                    .stream().map( a -> a.getAttribute("href")).toList();
//            cates.forEach(cate -> {
//                if(cate != null) {
//                    getPage.get(cate);
//                    String name = getPage.findElement(By.xpath("//h1[@class=\"u-flex align-items-center fs-p-20 fs-p-md-16 txt-gray-800 title-product-highlight\"]")).getText();
//                    System.out.println("name: " + name);
//                    List<WebElement> more = getPage.findElements(By.xpath("//a[@class=\"loadmore-highlight btn btn-rounded btn-outline-gray btn-md btn-sm-md btn-icon btn-icon-right loadMoreProducts loadMoreProducts-productBestSeller\"]"));
//                    while (more.size() > 0 && !more.get(0).getAttribute("style").equals("display: none;")) {
//                        more.get(0).click();
//                        more = getPage.findElements(By.xpath("//a[@class=\"loadmore-highlight btn btn-rounded btn-outline-gray btn-md btn-sm-md btn-icon btn-icon-right loadMoreProducts loadMoreProducts-productBestSeller\"]"));
//                    }
//                }
//            });
////            getPage.close();
//        });
    }
}
