package core.TAS.testrail;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.*;
import core.TAS.json.JsonUtility;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anonymous on 22.02.2019.
 */
public class TestRailUtility {

    private TestRail client;

    /**
     * constructor
     * @param client
     */
    public TestRailUtility(TestRail client) {
        this.client = client;
    }

    /**
     * constructor
     * @param host
     * @param username
     * @param password
     */
    public TestRailUtility(String host, String username, String password, String applicationName) {
        this.client = TestRail.builder(host, username, password).applicationName(applicationName).build();
    }

    // TODO: remove later
    public void test(){
        // project
        Project p = this.client.projects().get(1).execute();
        System.out.println( "Project id: " + p.getId() + "; name: "+ p.getName() );
        // run
        Run run = this.client.runs().get(1).execute();
        System.out.println( "run id: " + run.getId()+ "; runName: " + run.getName() );
        System.out.println( "runDescription:" + run.getDescription() );
        // list of testCases in run
        List<Test> tests = this.client.tests().list(1).execute();
        for (Test test: tests) {
            System.out.println("testCaseId: " + test.getCaseId() + " ; testCaseName: " + test.getTitle());
        }
        // fetch data from testcase
        List<CaseField> customCaseFields =  this.client.caseFields().list().execute();
        Case testCase =  this.client.cases().get(1, customCaseFields).execute();
        System.out.println("caseid: " + testCase.getId() + " ; testName: " + testCase.getTitle());
        ArrayList<Field.Step> steps = (ArrayList<Field.Step>)testCase.getCustomFields().get("steps_separated");
        for(Field.Step fieldStep: steps) {
            System.out.println("step: " + fieldStep.getContent() + "; expected result: " + fieldStep.getExpected());
        }
    }

    public Case getTestCase(int testCaseId){
        // fetch data from testcase
        List<CaseField> customCaseFields =  this.client.caseFields().list().execute();
        Case testCase =  this.client.cases().get(1, customCaseFields).execute();
        return testCase;
    }


}
