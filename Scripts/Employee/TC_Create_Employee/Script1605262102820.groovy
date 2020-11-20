import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import customKeywordCilsy.Storing_Random_Code as Storing_Random_Code

CustomKeywords.'customKeywordCilsy.Storing_Random_Code.Generate_Code'()

println('Employee Code : ' + GlobalVariable.code)

GlobalVariable.code = Storing_Random_Code.employee_code

println('Employee Code : ' + GlobalVariable.code)

post_loan = WS.sendRequestAndVerify(findTestObject('Employee/POST_Employee', [('code') : GlobalVariable.code, ('url') : GlobalVariable.url
            , ('token') : GlobalVariable.token]))

String apiPostLoanResponse = post_loan.getResponseText()

println('API Post Loan Response : ' + apiPostLoanResponse)

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(post_loan.getResponseBodyContent())

def id = result.id

println('Employee ID : ' + id)

GlobalVariable.id = id

println('Update Id : ' + GlobalVariable.id)

WS.sendRequestAndVerify(findTestObject('Employee/GET_Employee_Detail', [('url') : GlobalVariable.url, ('token') : GlobalVariable.token]))

