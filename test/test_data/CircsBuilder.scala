package test_data

import scala.xml.Elem

object CircsBuilder {
  def functionalTestCase1: Elem = {
    <DWPBody xmlns:ds="http://www.w3.org/2000/09/xmldsig#" xmlns="http://www.govtalk.gov.uk/dwp/carers-allowance"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://www.govtalk.gov.uk/dwp/carers-allowance file:/Users/jmi/Temp/CarersAllowance_Schema.xsd">
      <Version>0.1</Version>
      <DWPCATransaction>
        <TransactionId>NFM33DB</TransactionId>
        <DateTimeGenerated>02-10-2010 14:36</DateTimeGenerated>
        <DWPCAChangeOfCircumstances id="TEST432">
          <InitialQuestions>
            <ChangeAddress>Not asked</ChangeAddress>
            <ChangeName>Not asked</ChangeName>
            <ChangePayment>Not asked</ChangePayment>
            <ChangeBankDetails>Not asked</ChangeBankDetails>
            <PersonDied>Not asked</PersonDied>
            <PermanentlyStoppedCaring>Not asked</PermanentlyStoppedCaring>
            <BreakInCaring>Not asked</BreakInCaring>
            <CaringForDifferentPerson>Not asked</CaringForDifferentPerson>
            <StartedEmployment>Not asked</StartedEmployment>
            <StartedSelfEmployment>Not asked</StartedSelfEmployment>
            <ClaimADI>Not asked</ClaimADI>
            <AnyOtherChanges>yes</AnyOtherChanges>
          </InitialQuestions>
          <Claim>
            <ClaimantDetails>
              <Surname>Smith</Surname>
              <OtherNames>John Roger</OtherNames>
              <DateOfBirth>1950-04-03</DateOfBirth>
              <NationalInsuranceNumber>JA486278A</NationalInsuranceNumber>
              <Title>mr</Title>
              <Address>
                <gds:Line>101 Clifton Street</gds:Line> <gds:Line>Blackpool</gds:Line> <gds:Line></gds:Line> <gds:PostCode>PE1 4AQ</gds:PostCode>
              </Address>
              <ConfirmAddress>yes</ConfirmAddress>
              <HomePhone>123456</HomePhone>
              <DaytimePhone>
                <Number>34343434</Number>
                <Qualifier>mobile</Qualifier>
              </DaytimePhone>
              <EmailAddress/>
            </ClaimantDetails>
            <CareeDetails>
              <Surname>Smith</Surname>
              <OtherNames>John Roger</OtherNames>
              <DateOfBirth>1950-04-03</DateOfBirth>
              <NationalInsuranceNumber>JA486278A</NationalInsuranceNumber>
            </CareeDetails>
          </Claim>
          <OtherChanges>other text</OtherChanges>
          <ThirdParty>Not asked</ThirdParty>
          <Declaration>
            <TextLine>I declare that the information I have given on this form is correct and complete as far as I know and believe.</TextLine>
            <TextLine>I understand that if I knowingly give information that is incorrect or incomplete, I may be liable to prosecution or other action.</TextLine>
            <TextLine>I understand that I must promptly tell the office that pays my Carer's Allowance of anything that may affect my entitlement to, or the amount of, that benefit.</TextLine>
            <TextLine/>
            <TextLine>Do you agree to us obtaining information from any other persons or organisations you may have listed on this form? no</TextLine>
          </Declaration> <EvidenceList>
          <TextLine>XML Generated at: 2013-10-18T16:17:42</TextLine>
          <TextLine>
            ===============Consent and declaration===============
          </TextLine>
          <TextLine>Please tick this box to confirm that you understand and make the declarations above = yes</TextLine>
          <TextLine>I don't agree to you obtaining information from any other persons or organisations because = I don't want to</TextLine>
        </EvidenceList>
        </DWPCAChangeOfCircumstances>
      </DWPCATransaction>
    </DWPBody>
  }
}
