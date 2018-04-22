package reportingUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class created to creat json using gson
 * @author Vaibhav
 *
 */
public class TestObject {

	private String testName;
	private String testStatus;
	private Date startTime;
	private Date endTime;
	private String scrURL;
	private List<String> msg=new ArrayList<String>();
	private List<String> assertions=new ArrayList<String>();
	public List<String> getAssertions() {
		return assertions;
	}
	public void setAssertions(String assertions) {
		this.assertions.add(assertions+"\\n");
	}
	public void setMsg(List<String> msg) {
		this.msg = msg;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestStatus() {
		return testStatus;
	}
	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getScrURL() {
		return scrURL;
	}
	public void setScrURL(String scrURL) {
		this.scrURL = scrURL;
	}
	public List<String> getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg.add(msg+"\\n");
	}
}
