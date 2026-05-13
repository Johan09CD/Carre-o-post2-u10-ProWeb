package com.empresa.tareas.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TareasPage {

    private final WebDriver driver;
    private final By btnNueva = By.id("btn-nueva");
    private final By listItems = By.cssSelector(".tarea-item");

    public TareasPage(WebDriver driver) {
        this.driver = driver;
    }

    public int contarTareas() {
        return driver.findElements(listItems).size();
    }

    public boolean botonNuevaVisible() {
        return driver.findElements(btnNueva).size() > 0;
    }

    public String obtenerTitulo() {
        return driver.getTitle();
    }
}