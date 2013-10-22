package test_data

import scala.xml.Elem

object CircsBuilder {
  def functionalTestCase1: Elem = {

    <DWPBody xmlns:ds="http://www.w3.org/2000/09/xmldsig#" xmlns="http://www.govtalk.gov.uk/dwp/carers-allowance"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://www.govtalk.gov.uk/dwp/carers-allowance CarersAllowance_Schema_0.9.xsd">
      <Version>0.1</Version>
      <DWPCATransaction>
        <TransactionId>NFM33DB</TransactionId>
        <DateTimeGenerated>02-10-2010 14:36</DateTimeGenerated>
        <DWPCAChangeOfCircumstances>
          <Claim>
            <ClaimantDetails>
              <Surname>CaseCircsOne</Surname>
              <OtherNames>Test</OtherNames>
              <OtherSurnames>Smithson</OtherSurnames>
              <Title>Mr</Title>
              <DateOfBirth>28-09-1976</DateOfBirth>
              <NationalInsuranceNumber>JB486278C</NationalInsuranceNumber>
              <Address>
                <Line>1 Preston Road</Line>
                <Line>Preston</Line>
                <Line>Lancashire</Line>
                <PostCode>PR1 2TH</PostCode>
              </Address>
              <DayTimePhoneNumber>01772 888901</DayTimePhoneNumber>
              <MobileNumber>0771 5419808</MobileNumber>
            </ClaimantDetails>
            <CareeDetails>
              <Surname>PartnerCircsOne</Surname>
              <OtherNames>Test</OtherNames>
              <OtherSurnames>Watson</OtherSurnames>
              <Title>Dame</Title>
              <DateOfBirth>12-09-1980</DateOfBirth>
              <NationalInsuranceNumber>BA234567A</NationalInsuranceNumber>
              <Address>
                <Line>1a Preston Road</Line>
                <Line>Preston</Line>
                <Line>Lancashire</Line>
                <PostCode>PR1 2TH</PostCode>
              </Address>
              <DayTimePhoneNumber>01234 567890</DayTimePhoneNumber>
              <MobileNumber>0771 5419808</MobileNumber>
            </CareeDetails>
          </Claim>

          <OtherChanges>
            <QuestionLabel>Tell us about any changes</QuestionLabel>
            <Answer>I moved house blah blah</Answer>
          </OtherChanges>

          <Declaration>I am the customer and have completed the form myself.</Declaration>
          <EvidenceList>
            <RecipientAddress>
              <Line>CA Freepost</Line>
              <Line>Palatine House</Line>
              <Line>Preston</Line>
              <PostCode>PR1 1HN</PostCode>
            </RecipientAddress>
            <Evidence>
              <Title>Document you need to send us</Title>
              <Content>You must send us all the documents we ask for. If you do not, any benefit you may be entitled to my be delayed because of this claim. 1</Content>
              <Content>You must send us all the documents we ask for. If you do not, any benefit you may be entitled to my be delayed because of this claim. 2</Content>
              <Content>You must send us all the documents we ask for. If you do not, any benefit you may be entitled to my be delayed because of this claim. 3</Content>
            </Evidence>
            <Evidence>
              <Title>Pay Details</Title>
              <Content>You need to send us the last payslip before 10 Ocotber 2013 and all the payslips you have since then.</Content>
            </Evidence>
            <Evidence>
              <Title>Statement Signed</Title>
              <Content>You need to send us the completed and signed statement.</Content>
            </Evidence>
          </EvidenceList>
          <Consents>
            <Consent>
              <QuestionLabel>An example of a very long consent question so we can see the impact on the report and be sure that everything flows properly. Whenever there are multiple entries in an XML, one has to create subreport.</QuestionLabel>
              <Answer>Yes</Answer>
            </Consent>
            <Consent>
              <QuestionLabel>Another consent question</QuestionLabel>
              <Answer>Yes</Answer>
            </Consent>
          </Consents>
        </DWPCAChangeOfCircumstances>
      </DWPCATransaction>
      <ds:Signature xmlns:ds="http://www.w3.org/2000/09/xmldsig#">
        <ds:SignedInfo>
          <ds:CanonicalizationMethod Algorithm="http://www.w3.org/TR/2001/REC-xml-c14n-20010315"/>
          <ds:SignatureMethod Algorithm="http://www.w3.org/2000/09/xmldsig#dsa-sha1"/>
          <ds:Reference URI="DWPCATransaction">
            <ds:DigestMethod Algorithm="http://www.w3.org/2000/09/xmldsig#sha1"/>
            <ds:DigestValue>SadVcIUbeepTfvhp2BzI2V3EPYo=</ds:DigestValue>
          </ds:Reference>
        </ds:SignedInfo>
        <ds:SignatureValue>V6NzTYMiickLrbenHakT1UTnawk7CxWpqPtOh++XyCpg94LlWT682A==</ds:SignatureValue>
      </ds:Signature>
    </DWPBody>
  }
}
