package reportingUtils;

import java.util.Map;

import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;
import org.testng.collections.Maps;

import utils.ReportListener;

/**
 * Custom soft assert created to put assert message in test object
 * @author Vaibhav
 *
 */
public class CustomSoftAssert extends SoftAssert{
	 private final Map<AssertionError, IAssert<?>> m_errors = Maps.newLinkedHashMap();

	 @Override
     protected void doAssert(IAssert<?> a) {
         onBeforeAssert(a);
         try {
             a.doAssert();
             onAssertSuccess(a);
         } catch (AssertionError ex) {
             onAssertFailure(a, ex);
             ReportListener.test.get().setAssertions(ex.getMessage());
             m_errors.put(ex, a);
         } finally {
             onAfterAssert(a);
         }
     }
	 
	 public void assertAll() {
		    if (!m_errors.isEmpty()) {
		      StringBuilder sb = new StringBuilder("The following asserts failed:");
		      boolean first = true;
		      for (Map.Entry<AssertionError, IAssert<?>> ae : m_errors.entrySet()) {
		        if (first) {
		          first = false;
		        } else {
		          sb.append(",");
		        }
		        sb.append("\n\t");
		        sb.append(ae.getKey().getMessage());
		      }
		      throw new AssertionError(sb.toString());
		    }
		  }
}
