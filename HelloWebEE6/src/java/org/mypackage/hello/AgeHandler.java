/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.hello;

/**
 *
 * @author jonasviklund
 */
public class AgeHandler {
    private String age;
    
    public AgeHandler()
    {
            age = null;
    }
    
    /**
     * @return the Age
     */
    public String getAge()
    {
            return age;
    }
    /**
     * @param Age the name to set
     */
    public void setAge(String age)
    {
        this.age = age;
    }
}
