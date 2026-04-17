package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TesteSelenium {
    public static void main(String[] args){
        //configurando o ChromeDriver automaticamente
        WebDriverManager.chromedriver().setup();
        //criando instancia do chrome
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //abrindo o chrome
        driver.get("https://forms.cloud.microsoft/Pages/ResponsePage.aspx?id=HBQ2z9fdp0WwcxEfZtCzDFimoWho9WhOmnQCBjqY305UMU1GMEU1UlBRVEFYSUZNRkIyUzdKQlA2TS4u");

        //localizando a barra de busca
        WebElement campoResposta = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("textarea[data-automation-id='textInput']")
        ));
        //digitando o texto na barra de busca
        campoResposta.sendKeys("selenium on");

        //achando span de click
        WebElement choice = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("span[data-automation-id='radio'][data-automation-value='sim']")
        ));
        choice.click();

        //span de click de multipla escolha
        WebElement multiChoice = wait.until(ExpectedConditions.elementToBeClickable(
               By.cssSelector("span[data-automation-id='checkbox'][data-automation-value='perfeitamente']")
        ));
        multiChoice.click();

        // achando botao
        WebElement botaoEnviar = driver.findElement(By.cssSelector("button[data-automation-id='submitButton']"));
        //enviando a resposta
        botaoEnviar.click();
        //esperando msg de confirmação
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector("div[data-automation-id='thankYouMessage']")
        ));
        //driver.get("https://dev.to/jhonifaber/hexagonal-architecture-or-port-adapters-23ed?utm_source=chatgpt.com");
        //mostrando o titulo da página no console
        //System.out.println("titulo:" + driver.getTitle());
        //fechando o navegador
        //driver.quit();
    }

}
