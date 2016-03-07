/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payara.testapps.github663;

import javax.annotation.PostConstruct;

/**
 *
 * @author omihalyi
 */
public abstract class AbstractClassWithChekedExcInPostConstruct {
    
    @PostConstruct
    public void postConstruct() throws Exception {
        
    }
    
}
