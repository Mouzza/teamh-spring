describe("From a home page", function(){

    var orgTest = require("./../organisatie/t_organisatie.js");

    beforeEach(function(){
        orgTest();
    });

    it("user should be able to create main theme and attache existing organisation to it",function(){

        element(by.css(".nav-main-theme-btn")).click();
        element(by.id("form-title")).element(by.tagName("h2")).click();
        element(by.id("naam")).sendKeys("HW");
        element(by.id("beschrijving")).sendKeys("Handelswetenschappen");
        element(by.cssContainingText(".org-opt","KdG")).click();
        element(by.id("form")).element(by.tagName("button")).click();

        expect(element.all(by.css(".lijst-item")).count()).toBe(1);
        expect(browser.getCurrentUrl()).toEqual("http://localhost:8080/#/hoofdthemas")

    });

});