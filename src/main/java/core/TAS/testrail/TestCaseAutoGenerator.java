package core.TAS.testrail;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yauheniburau on 4/27/16.
 */
//@Aspect
//@Component
//public class TestCaseAutoGenerator extends BaseGenerator{
//
//    @Autowired
//    AssertUtility assertUtility;
//
////    private static ArrayList<Map> testCaseStepsData = new ArrayList<>();
//
//    private static final ThreadLocal<List<Map>> TEST_CASE_STEPS_DATA_THREAD_LOCAL = new ThreadLocal<>();
//
//    public static List<Map> getTestCaseStepsData() {
//        return TEST_CASE_STEPS_DATA_THREAD_LOCAL.get();
//    }
//
//    public static void setTestCaseStepsData(List<Map> testCaseStepsData) {
//        TEST_CASE_STEPS_DATA_THREAD_LOCAL.set(testCaseStepsData);
//    }
//
//
//    @Pointcut("@annotation(ru.yandex.qatools.allure.annotations.Step)")
//    public void getPointcutAllSteps() {}
//
//    @Around( "execution(* com.peterservice.cci.ccisrv.regression.steps..*.*(..)) && getPointcutAllSteps()" )
//    public Object aroundStep(ProceedingJoinPoint joinPoint) throws Throwable {
//        Map step;
//        String content, expected;
//        Object result = joinPoint.proceed();
//        if (isTestCaseAutoGenerate()){
//            // get step Info and add to array Of steps
//            step = new HashMap();
//            Object[] args = joinPoint.getArgs();
//            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//            Method targetMethod = methodSignature.getMethod();
//
//            Step stepAnnotation = targetMethod.getAnnotation(Step.class);
//            assertUtility.assertThatNotNullValue("There is no 'Step' annotation for executed step method:" + methodSignature.toString(), stepAnnotation);
//            content = stepAnnotation.value();
//            for(int n = 0; n< args.length; n++) {
//                content = content.replace( "{"+n+"}", args[n]==null? "null" : args[n].toString() );
//            }
//            ExpectedResult expectedResultAnnotation = targetMethod.getAnnotation(ExpectedResult.class);
//            assertUtility.assertThatNotNullValue("There is no 'ExpectedResult' annotation for executed step method:" + methodSignature.toString(), expectedResultAnnotation);
//            expected = expectedResultAnnotation.value();
//            for(int n = 0; n< args.length; n++) {
//                expected = expected.replace( "{"+n+"}", args[n]==null? "null" : args[n].toString() );
//            }
//            expected = expected.replace("{result}", result==null? "no result" : result.toString());
//
//            step.put(JsonTestRailKeys.CONTENT, content);
//            step.put(JsonTestRailKeys.EXPECTED, expected);
//            getTestCaseStepsData().add(step);
//        }
//        return result;
//    }
//
//    public static void clearTestCaseStepsData(){
//        setTestCaseStepsData(new ArrayList<>());
//    }
//
//}
