package trendYol.Bölüm2;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITest extends ApiTestCase {

    @Test
    public void Emptystore(){
        RequestSpecification request = RestAssured.given();
        Response response = request.get(API_ROOT + "api/books/");

        System.out.println(response.asString());
        int responseCode = response.getStatusCode();
        System.out.println(responseCode);
        Assert.assertEquals(responseCode,200);
        Assert.assertEquals(response.asString(),"[]");
    }

    @Test
    public void TitleandAuthorRequired(){
        BookData bookData = new BookData ("","yeni kitap" );

        RequestSpecification request = RestAssured.given();
        request.body(bookData).contentType(ContentType.JSON);
        Response response = request.post(API_ROOT + "api/books/");

        int statusCode = response.getStatusCode();
        System.out.println(response.asString());
        Assert.assertEquals(statusCode, 400);
    }

    @Test
    public void TitleandAuthorNotEmpty(){
        BookData bookData = new BookData (" ","" );

        RequestSpecification request = RestAssured.given();
        request.body(bookData).contentType(ContentType.JSON);
        Response response = request.post(API_ROOT + "api/books/");

        int statusCode = response.getStatusCode();
        System.out.println(response.asString());
        Assert.assertEquals(statusCode, 400);

    }
  

 

    @Test
    public void CreateNewBook(){
        BookData bookData = new BookData ("New Book","Doruk taskin");

        RequestSpecification request = RestAssured.given();
        request.body(bookData).contentType(ContentType.JSON);
        Response response = request.put(API_ROOT + "api/books/2");

        int statusCode = response.getStatusCode();
        System.out.println(response.asString());
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void IDReadOnly(){
        BookData bookData = new BookData();

        RequestSpecification request = RestAssured.given();
        bookData.setId(1);

        request.body(bookData).contentType(ContentType.JSON);
        Response response = request.put(API_ROOT + "api/books/1");

        int statusCode = response.getStatusCode();
        System.out.println(response.asString());
        Assert.assertEquals(statusCode, 400);

    }

  

}