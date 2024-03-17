package pl.amiskiewicz.creditcard;

import org.junit.jupiter.api.Test;
public class HelloTest {
    @Test

    void helloWorldTest(){
        //AAA
        //Arrange //Given
        var a=2;
        var b=4;
        //Act  //When
        var result = a+b;
        //Assert //Expected
        assert result == 6;

    }
    @Test
    void itShowsHello(){
        var hello= "hello Amanda";
    }
}
