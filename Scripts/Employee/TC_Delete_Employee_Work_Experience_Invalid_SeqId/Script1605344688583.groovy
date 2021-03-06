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

response = WS.sendRequestAndVerify(findTestObject('Employee/GET_Employee_Search', [('url') : GlobalVariable.url, ('token') : GlobalVariable.token]))

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(response.getResponseBodyContent())

def id = result.data[0].employeeId

println('Id is : ' + id)

GlobalVariable.id = id

println('Update Id is : ' + GlobalVariable.id)

response = WS.sendRequestAndVerify(findTestObject('Employee/GET_Employee_Work_Experience', [('url') : GlobalVariable.url
            , ('token') : GlobalVariable.token]))

def slurper1 = new groovy.json.JsonSlurper()

def result1 = slurper1.parseText(response.getResponseBodyContent())

def seqId = result1.data[0].id

println('SeqId is : ' + seqId)

GlobalVariable.seqId = seqId

println('Update SeqId is : ' + GlobalVariable.seqId)

WS.sendRequestAndVerify(findTestObject('Employee/DELETE_Employee_Work_Experience_Invalid_SeqId', [('url') : GlobalVariable.url, ('token') : GlobalVariable.token]))

