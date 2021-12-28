/*
 * psc-api-maj-v2
 * API CRUD for Personnels et Structures de santé
 *
 * OpenAPI spec version: 1.0
 * Contact: superviseurs.psc@esante.gouv.fr
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package fr.ans.psc.api;

import fr.ans.psc.model.Error;
import fr.ans.psc.model.PsRef;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ToggleApi
 */
@Ignore
public class ToggleApiTest {

    private final ToggleApi api = new ToggleApi();

    /**
     * toggle PsRef mapping
     *
     * Toggle PsRef mapping
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void togglePsrefTest() {
        PsRef body = null;
        api.togglePsref(body);

        // TODO: test validations
    }
}