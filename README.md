# ebayAutomation

Solution provided based on requirement

Use configuration file to drive automation execution 
< created test.properties file under src/java/resources/config folder User can modify browser name to run the same script over any browser, hub/node bat file present in {root}/driver folder needs to be running, currently node bat is made for chrome browser.

Prefer to use build tool to trigger clean/build/unit test/UI automation test
< Used Maven as build tool

Automation can be trigger via commandline: below steps should be trigger: 
< Use mvn clean test to run test script from commandline - it will run testng.xml placed under src/java/resources/config folder

a. Cleaning previous builds 
< Use Maven clean to clean older build files

b. Compiling the code 
< Use Maven compile >

c. Triggering Unit Test (if there is) 
< Use Maven clean test to run testng xml >

d. Triggering UI Automation

e. Generating report in 2 format: JSON and HTML (see the end of this file for which information need to be store in report) 
< 
Reports will be generated in build folder - build/report/Report.html, Once after test run it will be autopopulated based on json created under - build/report/testResult/report.json and images under build/report/images folder
>

Writing code in reusable manner. Suggesting to use PageObject, sharing classes/modules 
< 
Use page object model with custom factory, 

Test flow calling - Test Script >> Action method >> page method

Page class - Page Methods + Object References to object placed under - src/main/resources/objectRepository Action Class - Page 
method calling 

Sitefactory - All page/action classes are registered to factory to overcome object creation

ThreadLocal used to skip object creation of utils classes

Report listener/Custom soft Assert/TestObject created to fulfill reporting needs - 
a. Json object with test details 
b. Soft asserting and putting messages in json object 
c. Gson to convert test object to json

Test data is placed under src/main/resources/data
>

Data driven (reading data from file) (See the end of this file for data format) 
< Used testng data provider Test data is placed under src/main/resources/data >

Randomisation in selecting items. When need to select an item from list of item, please don’t select the first or last item of the list. Should be selecting any item from displayed list 
< Random item is getting picked from screen >

Programming language: prefer Java, but you’re welcome to use your most familiar language. 
< Programming language - Java >

Please find attached files under root folder Sample Report Screenshot : Sample.png Sample Report json : report.json

Note - Cannot proceed after Guest checkout - it is asking for mobile number verification in case of both guest/register user

Regards Vaibhav Singh vaibhav_singh17@infosys.com
