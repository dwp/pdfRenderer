package test_data

import scala.xml.Elem


object ClaimBuilder {

  def buildGoodClaim: Elem = {
    <DWPBody xmlns:ds="http://www.w3.org/2000/09/xmldsig#" xmlns="http://www.govtalk.gov.uk/dwp/carers-allowance"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://www.govtalk.gov.uk/dwp/carers-allowance file:/Users/jmi/Temp/CarersAllowance_Schema.xsd">
      <Version>0.1</Version>
      <DWPCATransaction>
        <TransactionId>NFM33DB</TransactionId>
        <DateTimeGenerated>02-10-2010 14:36</DateTimeGenerated>
        <DWPCAClaim>
          <DateOfClaim>
            <QuestionLabel>When do you want your Carer's Allowance claim to start?</QuestionLabel>
            <Answer>01-01-2010</Answer>
          </DateOfClaim>
          <Claimant>
            <Surname>CaseThree</Surname>
            <OtherNames>Test Middle</OtherNames>
            <OtherSurnames>Smithson</OtherSurnames>
            <Title>Mr</Title>
            <DateOfBitrh>01-01-1931</DateOfBitrh>
            <NationalInsuranceNumber>JB486278C</NationalInsuranceNumber>
            <Address>
              <Line>3 Preston Road</Line>
              <Line>Preston</Line>
              <Line>Lancashire</Line>
              <PostCode>PR1 2TH</PostCode>
            </Address>
            <DayTimePhoneNumber>01772 888901</DayTimePhoneNumber>
            <MobileNumber>0771 5419808</MobileNumber>
            <MaritalStatus>Single</MaritalStatus>
            <TextPhoneContact>
              <QuestionLabel>text.phone</QuestionLabel>
              <Answer>No</Answer>
            </TextPhoneContact>
          </Claimant>
          <Caree>
            <Surname>CaseThree</Surname>
            <OtherNames>Cloe Scott</OtherNames>
            <OtherSurnames>Watson</OtherSurnames>
            <Title>Dame</Title>
            <DateOfBitrh>03-7-1953</DateOfBitrh>
            <NationalInsuranceNumber>BA234567A</NationalInsuranceNumber>
            <Address>
              <Line>3a Preston Road</Line>
              <Line>Preston</Line>
              <Line>Lancashire</Line>
              <PostCode>PR1 2TH</PostCode>
            </Address>
            <DayTimePhoneNumber>01234 567890</DayTimePhoneNumber>
            <RelationToClaimant>
              <QuestionLabel>What's their relationshipt to you?</QuestionLabel>
              <Answer>Mother</Answer>
            </RelationToClaimant>
            <Cared35Hours>
              <QuestionLabel>Do you spend 35 hours or more each week caring for this person?</QuestionLabel>
              <Answer>Yes</Answer>
            </Cared35Hours>
            <BreaksSinceClaim>
              <QuestionLabel>Have you had any breaks in caring for this person since claim date?</QuestionLabel>
              <Answer>Yes</Answer>
            </BreaksSinceClaim>
            <CareBreak>
              <StartDateTime>10-07-2010 10:00</StartDateTime>
              <EndDateTime>17-07-2010 17:45</EndDateTime>
              <ReasonClaimant>
                <QuestionLabel>Where were you during the break?</QuestionLabel>
                <Other>Friend's place</Other>
                <Answer>Other</Answer>
              </ReasonClaimant>
              <ReasonCaree>
                <QuestionLabel>Where was the person you care for during the break?</QuestionLabel>
                <Answer>At Home</Answer>
              </ReasonCaree>
              <MedicalCare>
                <QuestionLabel>Did you or the person you care for receive any medical treatment or professional care during the break?</QuestionLabel>
                <Answer>No</Answer>
              </MedicalCare>
            </CareBreak>
            <CareBreak>
              <StartDateTime>10-09-2010 12:00</StartDateTime>
              <EndDateTime>17-09-2010 15:15</EndDateTime>
              <ReasonClaimant>
                <QuestionLabel>Where were you during the break?</QuestionLabel>
                <Answer>Hospital</Answer>
              </ReasonClaimant>
              <ReasonCaree>
                <QuestionLabel>Where was the person you care for during the break?</QuestionLabel>
                <Answer>At Home</Answer>
              </ReasonCaree>
              <MedicalCare>
                <QuestionLabel>Did you or the person you care for receive any medical treatment or professional care during the break?</QuestionLabel>
                <Answer>Yes</Answer>
              </MedicalCare>
            </CareBreak>
            <CareBreak>
              <StartDateTime>10-10-2010 10:30</StartDateTime>
            </CareBreak>
            <Cared35HoursBefore>
              <QuestionLabel>care.35.before</QuestionLabel>
              <Answer>No</Answer>
            </Cared35HoursBefore>
            <DateStartCaring>
              <QuestionLabel>care.started</QuestionLabel>
              <Answer>2010-05-01</Answer>
            </DateStartCaring>
            <LiveSameAddress>
              <QuestionLabel>caree.sameadrees</QuestionLabel>
              <Answer>Yes</Answer>
            </LiveSameAddress>
            <ArmedForcesIndependencePayment>
              <QuestionLabel>Does this person get Armed Forces Independence Payment?</QuestionLabel>
              <Answer>No</Answer>
            </ArmedForcesIndependencePayment>
          </Caree>
          <Residency>
            <NormallyLiveInGB>
              <QuestionLabel>live.normally.GB</QuestionLabel>
              <Answer>No</Answer>
            </NormallyLiveInGB>
            <CountryNormallyLive>
              <QuestionLabel>live.normally.country</QuestionLabel>
              <Answer>France</Answer>
            </CountryNormallyLive>
            <Nationality>British</Nationality>
            <TimeOutsideGBLast3Years>
              <QuestionLabel>Time.out.GB</QuestionLabel>
              <Answer>Yes</Answer>
            </TimeOutsideGBLast3Years>
            <PeriodAbroad>
              <Period>
                <DateFrom>
                  <QuestionLabel>abroad.date.from</QuestionLabel>
                  <Answer>2010-08-09</Answer>
                </DateFrom>
                <DateTo>
                  <QuestionLabel>abroad.date.to</QuestionLabel>
                  <Answer>2010-08-12</Answer>
                </DateTo>
              </Period>
              <Reason>
                <QuestionLabel>abroad.reason</QuestionLabel>
                <Other>Funeral</Other>
                <Answer>Other</Answer>
              </Reason>
              <Country>
                <QuestionLabel>country.went</QuestionLabel>
                <Answer>France</Answer>
              </Country>
              <CareePresent>
                <QuestionLabel>caree.present</QuestionLabel>
                <Answer>No</Answer>
              </CareePresent>
            </PeriodAbroad>
            <PeriodAbroad>
              <Period>
                <DateFrom>
                  <QuestionLabel>abroad.date.from</QuestionLabel>
                  <Answer>2011-06-09</Answer>
                </DateFrom>
                <DateTo>
                  <QuestionLabel>abroad.date.to</QuestionLabel>
                  <Answer>2011-06-12</Answer>
                </DateTo>
              </Period>
              <Reason>
                <QuestionLabel>abroad.reason</QuestionLabel>
                <Answer>Holiday</Answer>
              </Reason>
              <Country>
                <QuestionLabel>country.went</QuestionLabel>
                <Answer>Spain</Answer>
              </Country>
              <CareePresent>
                <QuestionLabel>caree.present</QuestionLabel>
                <Answer>Yes</Answer>
              </CareePresent>
            </PeriodAbroad>
          </Residency>
          <CourseOfEducation>
            <QuestionLabel>Have you been on a course of education since your claim date?</QuestionLabel>
            <Answer>Yes</Answer>
          </CourseOfEducation>
          <FullTimeEducation>
            <CourseDetails>
              <Type>BA honours in Business</Type>
              <Title>Bussines Studies</Title>
              <DateStarted>
                <QuestionLabel>education.started</QuestionLabel>
                <Answer>2013-01-01</Answer>
              </DateStarted>
              <!--               <DateStopped>
                        <QuestionLabel>education.ended</QuestionLabel>
                        <Answer>2013-05-04</Answer>
                    </DateStopped>
                    -->
              <ExpectedEndDate>
                <QuestionLabel>education.end.expected</QuestionLabel>
                <Answer>2014-05-01</Answer>
              </ExpectedEndDate>
            </CourseDetails>
            <LocationDetails>
              <Name>Oxford College</Name>
              <Address>
                <Line>1 Oxford Road</Line>
                <Line>Oxford</Line>
                <Line>Oxfordshire</Line>
                <PostCode>OX12 3RT</PostCode>
              </Address>
              <PhoneNumber>01776 829920</PhoneNumber>
              <FaxNumber>01776 829920</FaxNumber>
              <StudentReferenceNumber>91982</StudentReferenceNumber>
              <Tutor>My Tutor</Tutor>
            </LocationDetails>
          </FullTimeEducation>
          <SelfEmployed>
            <QuestionLabel>Have you been self-employed at any time since (this is one week before your claim date)?</QuestionLabel>
            <Answer>Yes</Answer>
          </SelfEmployed>
          <SelfEmployment>
            <SelfEmployedNow>
              <QuestionLabel>selfepmloyed.now</QuestionLabel>
              <Answer>No</Answer>
            </SelfEmployedNow>
            <RecentJobDetails>
              <DateStarted>
                <QuestionLabel>selfemployed.started</QuestionLabel>
                <Answer>2010-05-01</Answer>
              </DateStarted>
              <NatureBusiness>
                <QuestionLabel>selfemployed.business</QuestionLabel>
                <Answer>Fruit and veg, delivery service</Answer>
              </NatureBusiness>
              <TradingYear>
                <DateFrom>
                  <QuestionLabel>trading.from</QuestionLabel>
                  <Answer>2013-05-01</Answer>
                </DateFrom>
                <DateTo>
                  <QuestionLabel>trading.to</QuestionLabel>
                  <Answer>2014-04-30</Answer>
                </DateTo>
              </TradingYear>
              <SameIncomeOutgoingLevels>
                <QuestionLabel>selfemployed.level</QuestionLabel>
                <Answer>No</Answer>
              </SameIncomeOutgoingLevels>
              <WhyWhenChange>
                <QuestionLabel>slefemployed.level.change</QuestionLabel>
                <Answer>Depends on the seasons, and productivity of the fruit.</Answer>
              </WhyWhenChange>
              <DateEnded>
                <QuestionLabel>selfemployed.ended</QuestionLabel>
                <Answer>2013-09-01</Answer>
              </DateEnded>
              <TradingCeased>
                <QuestionLabel>selfemployed.ceased</QuestionLabel>
                <Answer>Yes</Answer>
              </TradingCeased>
            </RecentJobDetails>
            <!--                <CurrentJobDetails>
                    <DateStarted>
                        <QuestionLabel>QuestionLabel34</QuestionLabel>
                        <Answer>2006-05-04</Answer>
                    </DateStarted>
                    <NatureBusiness>
                        <QuestionLabel>QuestionLabel35</QuestionLabel>
                        <Answer>Answer23</Answer>
                    </NatureBusiness>
                    <TradingYear>
                        <DateFrom>
                            <QuestionLabel>QuestionLabel36</QuestionLabel>
                            <Answer>2006-05-04</Answer>
                        </DateFrom>
                        <DateTo>
                            <QuestionLabel>QuestionLabel37</QuestionLabel>
                            <Answer>2006-05-04</Answer>
                        </DateTo>
                    </TradingYear>
                    <SameIncomeOutgoingLevels>
                        <QuestionLabel>QuestionLabel38</QuestionLabel>
                        <Answer>Yes</Answer>
                    </SameIncomeOutgoingLevels>
                    <WhyWhenChange>
                        <QuestionLabel>QuestionLabel39</QuestionLabel>
                        <Answer>Answer25</Answer>
                    </WhyWhenChange>
                </CurrentJobDetails>-->
            <CareExpensesChildren>
              <QuestionLabel>self.child.expenses</QuestionLabel>
              <Answer>Yes</Answer>
            </CareExpensesChildren>
            <ChildCareExpenses>
              <CarerName>
                <QuestionLabel>self.child.carer</QuestionLabel>
                <Answer>Mr John Smith</Answer>
              </CarerName>
              <Expense>
                <Payment>
                  <QuestionLabel>self.child.care.amount</QuestionLabel>
                  <Answer>
                    <Currency>GBP</Currency>
                    <Amount>120.00</Amount>
                  </Answer>
                </Payment>
                <Frequency>
                  <QuestionLabel>self.child.care.frequency</QuestionLabel>
                  <Answer>Weekly</Answer>
                </Frequency>
              </Expense>
              <RelationshipCarerToClaimant>
                <QuestionLabel>self.child.rel.claimant</QuestionLabel>
                <Answer>Uncle</Answer>
              </RelationshipCarerToClaimant>
              <RelationshipCarerToPartner>
                <QuestionLabel>self.child.rel.partner</QuestionLabel>
                <Other>None</Other>
                <Answer>Other</Answer>
              </RelationshipCarerToPartner>
              <RelationToChild>
                <QuestionLabel>self.child.rel.child</QuestionLabel>
                <Answer>Uncle</Answer>
              </RelationToChild>
            </ChildCareExpenses>
            <CareExpensesCaree>
              <QuestionLabel>self.care.expenses</QuestionLabel>
              <Answer>Yes</Answer>
            </CareExpensesCaree>
            <CareExpenses>
              <CarerName>
                <QuestionLabel>self.care.carer</QuestionLabel>
                <Answer>Mrs Terry Smith</Answer>
              </CarerName>
              <Expense>
                <Payment>
                  <QuestionLabel>self.care.amount</QuestionLabel>
                  <Answer>
                    <Currency>GBP</Currency>
                    <Amount>400.00</Amount>
                  </Answer>
                </Payment>
                <Frequency>
                  <QuestionLabel>self.care.frequency</QuestionLabel>
                  <Other>Other expenses frequency</Other>
                  <Answer>Other</Answer>
                </Frequency>
              </Expense>
              <RelationshipCarerToClaimant>
                <QuestionLabel>self.care.rel.claimant</QuestionLabel>
                <Other>None</Other>
                <Answer>Other</Answer>
              </RelationshipCarerToClaimant>
              <RelationshipCarerToPartner>
                <QuestionLabel>self.care.rel.partner</QuestionLabel>
                <Answer>Aunt</Answer>
              </RelationshipCarerToPartner>
              <RelationshipCarerToCaree>
                <QuestionLabel>self.care.rel.caree</QuestionLabel>
                <Answer>Aunt</Answer>
              </RelationshipCarerToCaree>
            </CareExpenses>
            <PaidForPension>
              <QuestionLabel>self.pension</QuestionLabel>
              <Answer>Yes</Answer>
            </PaidForPension>
            <PensionScheme>
              <Payment>
                <QuestionLabel>self.pension.amount</QuestionLabel>
                <Answer>
                  <Currency>GBP</Currency>
                  <Amount>15.23</Amount>
                </Answer>
              </Payment>
              <Frequency>
                <QuestionLabel>self.pension.frequency</QuestionLabel>
                <Answer>Weekly</Answer>
              </Frequency>
            </PensionScheme>
          </SelfEmployment>
          <Employed>
            <QuestionLabel>Have you been employed at any time since (this is six months before your claim date)?</QuestionLabel>
            <Answer>Yes</Answer>
          </Employed>
          <Employment>
            <CurrentlyEmployed>
              <QuestionLabel>employed.currently</QuestionLabel>
              <Answer>Yes</Answer>
            </CurrentlyEmployed>
            <JobDetails>
              <Employer>
                <DateJobStarted>
                  <QuestionLabel>job.started</QuestionLabel>
                  <Answer>2013-01-01</Answer>
                </DateJobStarted>
                <!--        <DateJobEnded>
                            <QuestionLabel>job.ended</QuestionLabel>
                            <Answer>2013-07-01</Answer>
                        </DateJobEnded> -->
                <JobType>
                  <QuestionLabel>job.title</QuestionLabel>
                  <Answer>Hacker</Answer>
                </JobType>
                <ClockPayrollNumber>12345678</ClockPayrollNumber>
                <Name>Tesco's</Name>
                <Address>
                  <Line>23 Yeadon Way</Line>
                  <Line>Blackpool</Line>
                  <Line>Lancashire</Line>
                  <PostCode>FY4 5TH</PostCode>
                </Address>
                <EmployersPhoneNumber>01253 667889</EmployersPhoneNumber>
                <HaveFinishedJob>
                  <QuestionLabel>job.finished</QuestionLabel>
                  <Answer>No</Answer>
                </HaveFinishedJob>
                <!--               <P45LeavingDate>
                            <QuestionLabel>job.p45</QuestionLabel>
                            <Answer>2013-07-01</Answer>
                        </P45LeavingDate> -->
              </Employer>
              <Pay>
                <WeeklyHoursWorked>
                  <QuestionLabel>job.hours</QuestionLabel>
                  <Answer>25</Answer>
                </WeeklyHoursWorked>
                <DateLastPaid>
                  <QuestionLabel>job.lastpaid</QuestionLabel>
                  <Answer>2013-07-02</Answer>
                </DateLastPaid>
                <GrossPayment>
                  <QuestionLabel>job.pay</QuestionLabel>
                  <Answer>
                    <Currency>GBP</Currency>
                    <Amount>600.00</Amount>
                  </Answer>
                </GrossPayment>
                <IncludedInWage>
                  <QuestionLabel>job.pay.include</QuestionLabel>
                  <Answer>All amounts due</Answer>
                </IncludedInWage>
                <PayFrequency>
                  <QuestionLabel>job.pay.frequency</QuestionLabel>
                  <Answer>Four-Weekly</Answer>
                </PayFrequency>
                <UsualPayDay>
                  <QuestionLabel>job.day</QuestionLabel>
                  <Answer>Wednesday usually</Answer>
                </UsualPayDay>
                <ConstantEarnings>
                  <QuestionLabel>job.same.amount</QuestionLabel>
                  <Answer>Yes</Answer>
                </ConstantEarnings>
              </Pay>
              <OweMoney>
                <QuestionLabel>job.owe</QuestionLabel>
                <Answer>No</Answer>
              </OweMoney>
              <CareExpensesChildren>
                <QuestionLabel>chld.expenses</QuestionLabel>
                <Answer>Yes</Answer>
              </CareExpensesChildren>
              <ChildCareExpenses>
                <CarerName>
                  <QuestionLabel>child.carer</QuestionLabel>
                  <Answer>Mr Grandfather Senior</Answer>
                </CarerName>
                <Expense>
                  <Payment>
                    <QuestionLabel>child.care.amount</QuestionLabel>
                    <Answer>
                      <Currency>GBP</Currency>
                      <Amount>120.12</Amount>
                    </Answer>
                  </Payment>
                  <Frequency>
                    <QuestionLabel>child.care.frequency</QuestionLabel>
                    <Answer>Weekly</Answer>
                  </Frequency>
                </Expense>
                <RelationshipCarerToClaimant>
                  <QuestionLabel>child.care.rel.claimant</QuestionLabel>
                  <Answer>Father</Answer>
                </RelationshipCarerToClaimant>
                <RelationshipCarerToPartner>
                  <QuestionLabel>cild.care.rel.partner</QuestionLabel>
                  <Answer>Stepfather</Answer>
                </RelationshipCarerToPartner>
                <RelationToChild>
                  <QuestionLabel>child.care.rel.child</QuestionLabel>
                  <Answer>Grandfather</Answer>
                </RelationToChild>
              </ChildCareExpenses>
              <CareExpensesCaree>
                <QuestionLabel>care.expenses</QuestionLabel>
                <Answer>Yes</Answer>
              </CareExpensesCaree>
              <CareExpenses>
                <CarerName>
                  <QuestionLabel>care.carer</QuestionLabel>
                  <Answer>Carers UK Ltd</Answer>
                </CarerName>
                <Expense>
                  <Payment>
                    <QuestionLabel>care.carer.amount</QuestionLabel>
                    <Answer>
                      <Currency>GBP</Currency>
                      <Amount>150.55</Amount>
                    </Answer>
                  </Payment>
                  <Frequency>
                    <QuestionLabel>care.carer.frequency</QuestionLabel>
                    <Other>Annually</Other>
                    <Answer>Other</Answer>
                  </Frequency>
                </Expense>
                <RelationshipCarerToClaimant>
                  <QuestionLabel>care.carer.rel.claimant</QuestionLabel>
                  <Other>None</Other>
                  <Answer>Other</Answer>
                </RelationshipCarerToClaimant>
                <RelationshipCarerToPartner>
                  <QuestionLabel>care.carer.rel.partner</QuestionLabel>
                  <Other>None</Other>
                  <Answer>Other</Answer>
                </RelationshipCarerToPartner>
                <RelationshipCarerToCaree>
                  <QuestionLabel>care.carer.rel.caree</QuestionLabel>
                  <Other>None</Other>
                  <Answer>Other</Answer>
                </RelationshipCarerToCaree>
              </CareExpenses>
              <PaidForOccupationalPension>
                <QuestionLabel>pension.occupational</QuestionLabel>
                <Answer>Yes</Answer>
              </PaidForOccupationalPension>
              <OccupationalPension>
                <Payment>
                  <QuestionLabel>pension.occ.amount</QuestionLabel>
                  <Answer>
                    <Currency>GBP</Currency>
                    <Amount>350.10</Amount>
                  </Answer>
                </Payment>
                <Frequency>
                  <QuestionLabel>pension.occ.frequency</QuestionLabel>
                  <Other>Other frequency fo occupational scheme</Other>
                  <Answer>Other</Answer>
                </Frequency>
              </OccupationalPension>
              <PaidForPersonalPension>
                <QuestionLabel>pension.personal</QuestionLabel>
                <Answer>Yes</Answer>
              </PaidForPersonalPension>
              <PersonalPension>
                <Payment>
                  <QuestionLabel>pension.per.amount</QuestionLabel>
                  <Answer>
                    <Currency>GBP</Currency>
                    <Amount>200.1</Amount>
                  </Answer>
                </Payment>
                <Frequency>
                  <QuestionLabel>pension.per.frequency</QuestionLabel>
                  <Answer>Monthly</Answer>
                </Frequency>
              </PersonalPension>
              <PaidForJobExpenses>
                <QuestionLabel>job.expenses</QuestionLabel>
                <Answer>Yes</Answer>
              </PaidForJobExpenses>
              <JobExpenses>
                <Expense>
                  <QuestionLabel>job.expense</QuestionLabel>
                  <Answer>Petrol money for driving</Answer>
                </Expense>
              </JobExpenses>
              <OtherEmployment>
                <QuestionLabel>Other.eployment</QuestionLabel>
                <Answer>No</Answer>
              </OtherEmployment>
            </JobDetails>
          </Employment>
          <HavePartner>
            <QuestionLabel>Have you had a partner/spouse living with you since your claim date?</QuestionLabel>
            <Answer>Yes</Answer>
          </HavePartner>
          <Partner>
            <Surname>CaseThree</Surname>
            <OtherNames>Test Middle</OtherNames>
            <OtherSurnames>Dixon</OtherSurnames>
            <Title>Mrs</Title>
            <DateOfBitrh>1937-09-28</DateOfBitrh>
            <NationalInsuranceNumber>BA234567A</NationalInsuranceNumber>
            <!-- <Address>
                    <Line>Line4</Line>
                    <PostCode>GIR 0AA</PostCode>
                </Address>

                <MobileNumber>       </MobileNumber> -->
            <DayTimePhoneNumber>0987654321</DayTimePhoneNumber>
            <NationalityPartner>British</NationalityPartner>
            <RelationshipStatus>
              <SeparatedFromPartner>
                <QuestionLabel>partner.separated</QuestionLabel>
                <Answer>No</Answer>
              </SeparatedFromPartner>
            </RelationshipStatus>
            <IsCaree>
              <QuestionLabel>Is your partner/spouse the person you are claiming Carer's Allowance for?</QuestionLabel>
              <Answer>No</Answer>
            </IsCaree>
          </Partner>
          <OtherBenefits>
            <ClaimantBenefits>
              <StatePension>
                <QuestionLabel>Do you get State Pension?</QuestionLabel>
                <Answer>Yes</Answer>
              </StatePension>
            </ClaimantBenefits>
            <OtherMoneySSP>
              <QuestionLabel>ssp.money</QuestionLabel>
              <Answer>Yes</Answer>
            </OtherMoneySSP>
            <OtherMoneySSPDetails>
              <Payment>
                <Payment>
                  <QuestionLabel>ssp.amount</QuestionLabel>
                  <Answer>
                    <Currency>GBP</Currency>
                    <Amount>12</Amount>
                  </Answer>
                </Payment>
                <Frequency>
                  <QuestionLabel>ssp.frequency</QuestionLabel>
                  <Other>Every day and twice on Sundays</Other>
                  <Answer>Other</Answer>
                </Frequency>
              </Payment>
              <Name>Burger King</Name>
              <Address>
                <Line>102 Preston Road</Line>
                <Line>Preston</Line>
                <Line>Lancashire</Line>
                <PostCode>PR45 6YH</PostCode>
              </Address>
            </OtherMoneySSPDetails>
            <OtherMoneySP>
              <QuestionLabel>sp.money</QuestionLabel>
              <Answer>Yes</Answer>
            </OtherMoneySP>
            <OtherMoneySPDetails>
              <Payment>
                <Payment>
                  <QuestionLabel>sp.amount</QuestionLabel>
                  <Answer>
                    <Currency>GBP</Currency>
                    <Amount>120</Amount>
                  </Answer>
                </Payment>
                <Frequency>
                  <QuestionLabel>sp.frequency</QuestionLabel>
                  <Answer>Weekly</Answer>
                </Frequency>
              </Payment>
              <Name>KFC</Name>
              <Address>
                <Line>104 Preston Road</Line>
                <Line>Preston</Line>
                <Line>Lancashire</Line>
                <PostCode>PR45 6YH</PostCode>
              </Address>
            </OtherMoneySPDetails>
            <OtherMoney>
              <QuestionLabel>Have you or your Partner or Spouse claimed or received any other benefits since the date you want to claim?</QuestionLabel>
              <Answer>Yes</Answer>
            </OtherMoney>
            <OtherMoneyDetails>
              <Payment>
                <Payment>
                  <QuestionLabel>Other.amount</QuestionLabel>
                  <Answer>
                    <Currency>GBP</Currency>
                    <Amount>123.57</Amount>
                  </Answer>
                </Payment>
                <Frequency>
                  <QuestionLabel>Other.frequency</QuestionLabel>
                  <Other>Quarterly</Other>
                  <Answer>Other</Answer>
                </Frequency>
              </Payment>
              <Name>
                <QuestionLabel>Other.who</QuestionLabel>
                <Answer>The Man</Answer>
              </Name>
            </OtherMoneyDetails>
            <EEA>
              <EEAClaimPensionsBenefits>
                <QuestionLabel>eea.pension</QuestionLabel>
                <Answer>Yes</Answer>
              </EEAClaimPensionsBenefits>
              <EEAReceivePensionsBenefits>
                <QuestionLabel>eea.pension</QuestionLabel>
                <Answer>Yes</Answer>
              </EEAReceivePensionsBenefits>
              <EEAWorkingInsurance>
                <QuestionLabel>eea.insurance</QuestionLabel>
                <Answer>No</Answer>
              </EEAWorkingInsurance>
            </EEA>

          </OtherBenefits>
          <Payment>
            <PaymentFrequency>
              <QuestionLabel>payment.frequency</QuestionLabel>
              <Answer>Weekly</Answer>
            </PaymentFrequency>
            <InitialAccountQuestion>
              <QuestionLabel>payment.way</QuestionLabel>
              <Answer>UK bank or building society</Answer>
            </InitialAccountQuestion>
            <Account>
              <HolderName>Mr Test Casetwo</HolderName>
              <BuildingSocietyDetails>
                <AccountNumber>12345678</AccountNumber>
                <!--    <RollNumber>RollNumber0</RollNumber> -->
                <SortCode>090126</SortCode>
                <Name>Santander</Name>
              </BuildingSocietyDetails>
            </Account>
          </Payment>
          <OtherInformation>
            <WelshCommunication>
              <QuestionLabel>welsh.communication</QuestionLabel>
              <Answer>No</Answer>
            </WelshCommunication>
            <AdditionalInformation>
              <QuestionLabel>anything.else</QuestionLabel>
              <Answer>It takes too long to claim. But I can write a very long answer here. 2000 characters.</Answer>
            </AdditionalInformation>
          </OtherInformation>
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
        </DWPCAClaim>
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

  def buildBadClaim: Elem = {
    <DWPBody xmlns:ds="http://www.w3.org/2000/09/xmldsig#" xmlns="http://www.govtalk.gov.uk/dwp/carers-allowance"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://www.govtalk.gov.uk/dwp/carers-allowance file:/Users/jmi/Temp/CarersAllowance_Schema.xsd">
      <Version>0.1</Version>
      <DWPCATransaction>
        <TransactionId>NFM33DB</TransactionId>
        <DateTimeGenerated>02-10-2010 14:36</DateTimeGenerated>
      </DWPCATransaction>
    </DWPBody>
  }

  def functionalTestCase1: Elem = {
    <DWPBody xmlns:ds="http://www.w3.org/2000/09/xmldsig#" xmlns="http://www.govtalk.gov.uk/dwp/carers-allowance"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://www.govtalk.gov.uk/dwp/carers-allowance file:/Users/jmi/Temp/CarersAllowance_Schema.xsd">
      <Version>0.1</Version>
      <DWPCATransaction>
        <TransactionId>NFM33DB</TransactionId>
        <DateTimeGenerated>02-10-2010 14:36</DateTimeGenerated>
        <DWPCAClaim id="TEST432">
          <Claimant>
            <DateOfClaim>2013-07-21</DateOfClaim>
            <Surname>Caseone</Surname>
            <OtherNames>Test</OtherNames>
            <OtherSurnames></OtherSurnames>
            <Title>mr</Title>
            <MaritalStatus>p</MaritalStatus>
            <DateOfBirth>1976-09-28</DateOfBirth>
            <NationalInsuranceNumber></NationalInsuranceNumber>
            <ExistingNationalInsuranceNumber/>
            <Address>
              <gds:Line>1 Preston Road</gds:Line> <gds:Line>Preston</gds:Line> <gds:Line></gds:Line> <gds:PostCode>PR1 1HB</gds:PostCode>
            </Address>
            <ConfirmAddress>yes</ConfirmAddress>
            <HomePhoneNumber></HomePhoneNumber>
            <DaytimePhoneNumber>
              <Number></Number>
              <Qualifier/>
            </DaytimePhoneNumber>
            <EmailAddress/>
            <ClaimedBefore>Not asked</ClaimedBefore>
          </Claimant>
          <Caree>
            <Surname>Caseone</Surname>
            <OtherNames>Test</OtherNames>
            <Title>dame</Title>
            <DateOfBirth>1980-09-12</DateOfBirth>
            <NationalInsuranceNumber></NationalInsuranceNumber>
            <Address>
              <gds:Line>1 Preston Road</gds:Line> <gds:Line>Preston</gds:Line> <gds:Line></gds:Line> <gds:PostCode>PR1 1HB</gds:PostCode>
            </Address>
            <ConfirmAddress>yes</ConfirmAddress>
            <HomePhoneNumber/>
            <DaytimePhoneNumber>
              <Number></Number>
              <Qualifier/>
            </DaytimePhoneNumber>
            <RelationToClaimant>partner</RelationToClaimant>
            <Cared35hours>Not asked</Cared35hours>
            <CanCareeSign>Not asked</CanCareeSign>
            <CanSomeoneElseSign>Not asked</CanSomeoneElseSign>
            <CanClaimantSign>Not asked</CanClaimantSign>
            <BreaksSinceClaim>no</BreaksSinceClaim>

            <Cared35hoursBefore>Not asked</Cared35hoursBefore>
            <DateStartedCaring>2012-01-21</DateStartedCaring>
            <BreaksBeforeClaim>no</BreaksBeforeClaim>
            <PaidForCaring>Not asked</PaidForCaring>
            <ClaimedPreviously>Not asked</ClaimedPreviously>
          </Caree>
          <ClaimADI>no</ClaimADI>
          <Residency>
            <Nationality>British</Nationality>
            <EUEEASwissNational>Not asked</EUEEASwissNational>
            <CountryNormallyLive>Not asked</CountryNormallyLive>
            <CountryNormallyLiveOther>Not asked</CountryNormallyLiveOther>
            <InGreatBritainNow>yes</InGreatBritainNow>
            <InGreatBritain26Weeks>Not asked</InGreatBritain26Weeks>

            <BritishOverseasPassport>Not asked</BritishOverseasPassport>

            <OutOfGreatBritain>Not asked</OutOfGreatBritain>

          </Residency>
          <CourseOfEducation>no</CourseOfEducation>

          <SelfEmployed>no</SelfEmployed>

          <Employed>no</Employed>

          <PropertyRentedOut>
            <PayNationalInsuranceContributions/>
            <RentOutProperty>Not asked</RentOutProperty>
            <SubletHome>Not asked</SubletHome>
          </PropertyRentedOut>
          <HavePartner>no</HavePartner>

          <OtherBenefits>
            <ClaimantBenefits>
              <JobseekersAllowance>no</JobseekersAllowance>
              <IncomeSupport>no</IncomeSupport>
              <PensionCredit>no</PensionCredit>
              <StatePension>no</StatePension>
              <IncapacityBenefit>no</IncapacityBenefit>
              <SevereDisablementAllowance>no</SevereDisablementAllowance>
              <MaternityAllowance>no</MaternityAllowance>
              <UnemployabilitySupplement>no</UnemployabilitySupplement>
              <WindowsBenefit>no</WindowsBenefit>
              <WarWidowsPension>no</WarWidowsPension>
              <IndustrialDeathBenefit>no</IndustrialDeathBenefit>
              <GovernmentTrainingAllowance>no</GovernmentTrainingAllowance>
              <LoneParentChildBenefit>no</LoneParentChildBenefit>
              <OtherSocialSecurityBenefit>Not asked</OtherSocialSecurityBenefit>
              <NonSocialSecurityBenefit>Not asked</NonSocialSecurityBenefit>
              <NoBenefits>Not asked</NoBenefits>
            </ClaimantBenefits>
            <PartnerBenefits>
              <JobseekersAllowance>no</JobseekersAllowance>
              <IncomeSupport>no</IncomeSupport>
              <PensionCredit>no</PensionCredit>
              <StatePension>no</StatePension>
              <IncapacityBenefit>no</IncapacityBenefit>
              <SevereDisablementAllowance>no</SevereDisablementAllowance>
              <MaternityAllowance>no</MaternityAllowance>
              <UnemployabilitySupplement>no</UnemployabilitySupplement>
              <WindowsBenefit>no</WindowsBenefit>
              <WarWidowsPension>no</WarWidowsPension>
              <IndustrialDeathBenefit>no</IndustrialDeathBenefit>
              <GovernmentTrainingAllowance>no</GovernmentTrainingAllowance>
              <OtherSocialSecurityBenefit>Not asked</OtherSocialSecurityBenefit>
              <NonSocialSecurityBenefit>Not asked</NonSocialSecurityBenefit>
              <NoBenefits>Not asked</NoBenefits>
            </PartnerBenefits>
            <ExtraMoney>Not asked</ExtraMoney>
            <OtherMoneySSP>no</OtherMoneySSP>
            <OtherMoneySMP>no</OtherMoneySMP>
          </OtherBenefits>
          <Payment>
            <PaymentFrequency>Not asked</PaymentFrequency>
            <InitialAccountQuestion>Not asked</InitialAccountQuestion>

          </Payment>
          <OtherInformation/>
          <ThirdParty>no</ThirdParty>
          <Declaration>


            <TextLine>Do you agree to us getting information from any other person or organisation you have told us about as part of this claim? Yes</TextLine>


            <TextLine>This is my claim for Carer's Allowance.</TextLine>
            <TextLine>I understand that if I am paid Carer's Allowance it may affect the benefits paid to Test Caseone.</TextLine>
            <TextLine>If the person you are caring for receives certain benefits, the amount they receive may be affected by your claim for Carer's Allowance. Because of this we need both of you to understand the potential consequences of your claim to Carer's Allowance.</TextLine>
            <TextLine>If Test Caseone gets a Severe Disability Premium with their income-based Jobseeker's Allowance, Income Support, income-related Employment and Support Allowance, Housing Benefit, they may no longer get that premium if we pay Carer's Allowance to you.</TextLine>
            <TextLine>If Test Caseone's Pension Credit includes an extra amount for severe disability, they may no longer get that extra amount if we pay Carer's Allowance to you.</TextLine>
            <TextLine>This could also affect any reduction in Council Tax Test Caseone may be entitled to. To find out more about it, please contact the Local Authority.</TextLine>
            <TextLine>We will need to check Test Caseone entitlement to Disability Living Allowance, Personal Independence Payment, Attendance Allowance, Constant Attendance Allowance or Armed Forces Independence Payment when considering your claim.</TextLine>
            <TextLine>We may contact Test Caseone or their representative to establish whether 35 hours caring per week is taking place.</TextLine>
            <TextLine></TextLine>
            <TextLine>Please tick this box to declare that you have understood the notes and you have made / will make the person you are caring for / or their representative aware that there could be a change to their benefits. = yes</TextLine>

            <TextLine>I declare that I understand the Carer's Allowance Claim Notes and that the information provided on this claim form is correct and complete.</TextLine>
            <TextLine>I understand that I must report all changes in my circumstances or that of the person that I am caring for which may affect my entitlement promptly and by failing to do so I may be liable to prosecution or face a financial penalty.</TextLine>
            <TextLine>I will phone 08456084321 or write to Carer's Allowance Unit, Palatine House, Preston, Lancaster, PR1 1HB to report a change in my circumstances or that of the person that I am caring for.</TextLine>
            <TextLine>If I give false or incomplete information or fail to report changes in my circumstances or that of the person that I am caring for promptly, I understand that my Carer's Allowance may be stopped or reduced and any overpayment of Carer's Allowance may be recovered. In addition I may be prosecuted or face a financial penalty.</TextLine>
            <TextLine>We may wish to contact any current or previous employers, or other persons or organisations you have listed on this claim form to obtain information about your claim. You do not have to agree to this but if you do not, it may mean that we are unable to obtain enough information to satisfy ourselves that you meet the conditions of entitlement for your claim.</TextLine>
            <TextLine></TextLine>
            <TextLine>Please tick this box to confirm that you understand and make the declarations above. = yes</TextLine>
            <TextLine>Please tick this box if this claim form has been filled in by someone else, if so, please ensure that you understand the declarations above as another person cannot make the declarations on your behalf. = yes</TextLine>

            <TextLine>Do you live in Wales and would like to receive future communications in Welsh? No</TextLine>
          </Declaration>
          <EvidenceList>
            <TextLine>
              XML Generated at: 2013-10-16T11:51:11
            </TextLine> <TextLine>
            ======================About You======================
          </TextLine> <TextLine>
            Have you always lived in the UK? = Yes
          </TextLine> <TextLine/>
            <TextLine/> <TextLine>
            Do you get state Pension? = Yes
          </TextLine> <TextLine/> <TextLine>
            ================About Care You Provide================
          </TextLine> <TextLine>
            Do they live at the same address as you? = Yes
          </TextLine> <TextLine>
            Does this person get Armed Forces Independence Payment? = Yes
          </TextLine> <TextLine>
            Do you spend 35 hours or more each week caring for this person? = Yes
          </TextLine> <TextLine>
            Did you care for this person for 35 hours or more each week before your claim date ? = Yes
          </TextLine> <TextLine>
            =====================Time abroad=====================
          </TextLine> <TextLine>
            Do you normally live in the UK, Republic of Ireland, Isle of Man or the Channel Islands? = Yes
          </TextLine> <TextLine>
            Have you had any more trips out of Great Britain for more than 52 weeks at a time, since 21/07/2013 (this is 156 weeks before your claim date)? = No
          </TextLine> <TextLine>
            Have you been out of Great Britain with the person you care for, for more than four weeks at a time, since 21/07/2013 (this is 3 years before your claim date)? = No
          </TextLine> <TextLine>
            =====================Other Money=====================
          </TextLine> <TextLine>
            Have you
            &lt;
            or your partner/spouse
            &gt;
            claimed or received any other benefits since the date you want to claim? = No
          </TextLine> <TextLine>
            Have you received any payments for the person you care for or any other person since your claim date? = No
          </TextLine> <TextLine/>
            <TextLine/>
            <TextLine/>
            <TextLine/>
            <TextLine/>
            <TextLine/>
            <TextLine/>
            <TextLine/>
            <TextLine/>
            <TextLine/> <TextLine>
            Are you, your wife, husband, civil partner or parent you are dependent on, receiving any pensions or benefits from another EEA State or Switzerland? = No
          </TextLine> <TextLine>
            Are you, your wife, husband, civil partner or parent you are dependent on working in or paying insurance to another EEA State or Switzerland? = No
          </TextLine>
          </EvidenceList>
        </DWPCAClaim>
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

  def functionalTestCase2: Elem = {
    <DWPBody xmlns:ds="http://www.w3.org/2000/09/xmldsig#" xmlns="http://www.govtalk.gov.uk/dwp/carers-allowance"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://www.govtalk.gov.uk/dwp/carers-allowance file:/Users/jmi/Temp/CarersAllowance_Schema.xsd">
      <Version>0.1</Version>
      <DWPCATransaction>
        <TransactionId>NFM33DB</TransactionId>
        <DateTimeGenerated>02-10-2010 14:36</DateTimeGenerated>
        <DWPCAClaim id="TEST432">
          <Claimant>
            <DateOfClaim>2013-03-22</DateOfClaim>
            <Surname>CaseTwo</Surname>
            <OtherNames>Test Middle</OtherNames>
            <OtherSurnames>Johnson</OtherSurnames>
            <Title>rev</Title>
            <MaritalStatus>w</MaritalStatus>
            <DateOfBirth>1976-09-28</DateOfBirth>
            <NationalInsuranceNumber>JA486278A</NationalInsuranceNumber>
            <ExistingNationalInsuranceNumber/>
            <Address>
              <gds:Line>2 Preston Road</gds:Line> <gds:Line>Preston</gds:Line> <gds:Line>Lancashire</gds:Line> <gds:PostCode>PR1 2TH</gds:PostCode>
            </Address>
            <ConfirmAddress>yes</ConfirmAddress>
            <HomePhoneNumber></HomePhoneNumber>
            <DaytimePhoneNumber>
              <Number>01772 888901</Number>
              <Qualifier/>
            </DaytimePhoneNumber>
            <EmailAddress/>
            <ClaimedBefore>Not asked</ClaimedBefore>
          </Claimant>
          <Caree>
            <Surname>For</Surname>
            <OtherNames>Person Cared</OtherNames>
            <Title>mr</Title>
            <DateOfBirth>1923-09-12</DateOfBirth>
            <NationalInsuranceNumber>JA789871C</NationalInsuranceNumber>
            <Address>
              <gds:Line>12 Preston Road</gds:Line> <gds:Line>Preston</gds:Line> <gds:Line>Lancashire</gds:Line> <gds:PostCode>PR1 2TH</gds:PostCode>
            </Address>
            <ConfirmAddress>yes</ConfirmAddress>
            <HomePhoneNumber/>
            <DaytimePhoneNumber>
              <Number>01772 998761</Number>
              <Qualifier/>
            </DaytimePhoneNumber>
            <RelationToClaimant>father</RelationToClaimant>
            <Cared35hours>Not asked</Cared35hours>
            <CanCareeSign>Not asked</CanCareeSign>
            <CanSomeoneElseSign>Not asked</CanSomeoneElseSign>
            <CanClaimantSign>Not asked</CanClaimantSign>
            <BreaksSinceClaim>no</BreaksSinceClaim>

            <Cared35hoursBefore>Not asked</Cared35hoursBefore>


            <PaidForCaring>Not asked</PaidForCaring>
            <ClaimedPreviously>Not asked</ClaimedPreviously>
          </Caree>
          <ClaimADI>no</ClaimADI>
          <Residency>
            <Nationality>British</Nationality>
            <EUEEASwissNational>Not asked</EUEEASwissNational>
            <CountryNormallyLive>France</CountryNormallyLive>
            <CountryNormallyLiveOther>Not asked</CountryNormallyLiveOther>
            <InGreatBritainNow>yes</InGreatBritainNow>
            <InGreatBritain26Weeks>Not asked</InGreatBritain26Weeks>
            <PeriodAbroadLastYear>
              <Period>
                <DateFrom>2013-05-31</DateFrom>
                <DateTo>2013-06-09</DateTo>
              </Period>
              <Reason>Holiday, on the Costa del Sol.</Reason>
              <Country>Spain</Country>
            </PeriodAbroadLastYear>
            <BritishOverseasPassport>Not asked</BritishOverseasPassport>
            <OtherNationality>
              <EUEEASwissNationalChildren/>
              <DateArrivedInGreatBritain>Not asked</DateArrivedInGreatBritain>
              <CountryArrivedFrom>France</CountryArrivedFrom>
              <IntendToReturn>yes</IntendToReturn>
              <DateReturn>2013-09-28</DateReturn>
              <VisaReferenceNumber>Not asked</VisaReferenceNumber>
            </OtherNationality>
            <OutOfGreatBritain>Not asked</OutOfGreatBritain>
            <PeriodAbroadDuringCare>
              <Period>
                <DateFrom>2011-05-31</DateFrom>
                <DateTo>2012-06-01</DateTo>
              </Period>
              <Reason>Long holiday</Reason>
            </PeriodAbroadDuringCare>
          </Residency>
          <CourseOfEducation>yes</CourseOfEducation>
          <FullTimeEducation>
            <CourseDetails>
              <Type>BA honours in Business</Type>
              <Title>Bussines Studies</Title>
              <HoursSpent></HoursSpent>
              <DateStarted>2013-01-01</DateStarted>
              <DateStopped></DateStopped>
              <ExpectedEndDate>2014-01-01</ExpectedEndDate>
            </CourseDetails>
            <LocationDetails>
              <Name>Oxford College</Name>
              <Address>
                <gds:Line>1 Oxford Road</gds:Line> <gds:Line>Oxford</gds:Line> <gds:Line>Oxfordshire</gds:Line> <gds:PostCode>OX12 3RT</gds:PostCode>
              </Address>
              <PhoneNumber>01776 829920</PhoneNumber>
              <FaxNumber>01776 829921</FaxNumber>
              <StudentReferenceNumber>91982</StudentReferenceNumber>
              <Tutor></Tutor>
            </LocationDetails>
          </FullTimeEducation>
          <SelfEmployed>no</SelfEmployed>

          <Employed>no</Employed>

          <PropertyRentedOut>
            <PayNationalInsuranceContributions/>
            <RentOutProperty>Not asked</RentOutProperty>
            <SubletHome>Not asked</SubletHome>
          </PropertyRentedOut>
          <HavePartner>yes</HavePartner>
          <Partner>
            <NationalityPartner>French</NationalityPartner>
            <Surname>CaseTwo</Surname>
            <OtherNames>Test Middle</OtherNames>
            <OtherSurnames>Dixon</OtherSurnames>
            <Title>mrs</Title>
            <DateOfBirth>1977-09-28</DateOfBirth>
            <NationalInsuranceNumber>JA234567B</NationalInsuranceNumber>
            <Address>
              <gds:Line>Not asked</gds:Line> <gds:Line></gds:Line> <gds:Line></gds:Line> <gds:PostCode></gds:PostCode>
            </Address>
            <ConfirmAddress>yes</ConfirmAddress>
            <RelationshipStatus>
              <JoinedHouseholdAfterDateOfClaim>Not asked</JoinedHouseholdAfterDateOfClaim>
              <JoinedHouseholdDate></JoinedHouseholdDate>
              <SeparatedFromPartner>no</SeparatedFromPartner>
              <SeparationDate></SeparationDate>
            </RelationshipStatus>
          </Partner>
          <OtherBenefits>
            <ClaimantBenefits>
              <JobseekersAllowance>no</JobseekersAllowance>
              <IncomeSupport>no</IncomeSupport>
              <PensionCredit>no</PensionCredit>
              <StatePension>no</StatePension>
              <IncapacityBenefit>no</IncapacityBenefit>
              <SevereDisablementAllowance>no</SevereDisablementAllowance>
              <MaternityAllowance>no</MaternityAllowance>
              <UnemployabilitySupplement>no</UnemployabilitySupplement>
              <WindowsBenefit>no</WindowsBenefit>
              <WarWidowsPension>no</WarWidowsPension>
              <IndustrialDeathBenefit>no</IndustrialDeathBenefit>
              <GovernmentTrainingAllowance>no</GovernmentTrainingAllowance>
              <LoneParentChildBenefit>no</LoneParentChildBenefit>
              <OtherSocialSecurityBenefit>Not asked</OtherSocialSecurityBenefit>
              <NonSocialSecurityBenefit>Not asked</NonSocialSecurityBenefit>
              <NoBenefits>Not asked</NoBenefits>
            </ClaimantBenefits>
            <PartnerBenefits>
              <JobseekersAllowance>no</JobseekersAllowance>
              <IncomeSupport>no</IncomeSupport>
              <PensionCredit>no</PensionCredit>
              <StatePension>no</StatePension>
              <IncapacityBenefit>no</IncapacityBenefit>
              <SevereDisablementAllowance>no</SevereDisablementAllowance>
              <MaternityAllowance>no</MaternityAllowance>
              <UnemployabilitySupplement>no</UnemployabilitySupplement>
              <WindowsBenefit>no</WindowsBenefit>
              <WarWidowsPension>no</WarWidowsPension>
              <IndustrialDeathBenefit>no</IndustrialDeathBenefit>
              <GovernmentTrainingAllowance>no</GovernmentTrainingAllowance>
              <OtherSocialSecurityBenefit>Not asked</OtherSocialSecurityBenefit>
              <NonSocialSecurityBenefit>Not asked</NonSocialSecurityBenefit>
              <NoBenefits>Not asked</NoBenefits>
            </PartnerBenefits>
            <ExtraMoney>Not asked</ExtraMoney>
            <OtherMoneySSP>yes</OtherMoneySSP> <OtherMoneySSPDetails>
            <Name>Burger King</Name>
            <Address>
              <gds:Line>102 Preston Road</gds:Line> <gds:Line>Preston</gds:Line> <gds:Line>Lancashure</gds:Line> <gds:PostCode>PR45 6YH</gds:PostCode>
            </Address>
            <ConfirmAddress>yes</ConfirmAddress>
          </OtherMoneySSPDetails>
            <OtherMoneySMP>yes</OtherMoneySMP> <OtherMoneySMPDetails>
            <Name>Burger King</Name>
            <Address>
              <gds:Line>102 Preston Road</gds:Line> <gds:Line>Preston</gds:Line> <gds:Line>Lancashure</gds:Line> <gds:PostCode>PR45 6YH</gds:PostCode>
            </Address>
            <ConfirmAddress>yes</ConfirmAddress>
          </OtherMoneySMPDetails>
          </OtherBenefits>
          <Payment>
            <PaymentFrequency>everyWeek</PaymentFrequency>
            <InitialAccountQuestion>bankBuildingAccount</InitialAccountQuestion>
            <Account>
              <DirectPayment>Not asked</DirectPayment>
              <AccountHolder>partner</AccountHolder>
              <HolderName>Mr Test Casetwo</HolderName>
              <SecondHolderName/>
              <AccountType>bank</AccountType>
              <OtherBenefitsToBePaidDirect/>
              <BuildingSocietyDetails>
                <BuildingSocietyQualifier/>
                <AccountNumber>12345678</AccountNumber>
                <RollNumber></RollNumber>
                <SortCode>090126</SortCode>
                <Name>Santander</Name>
                <Branch></Branch>
                <Address>
                  <gds:Line></gds:Line> <gds:Line></gds:Line> <gds:Line></gds:Line> <gds:PostCode></gds:PostCode>
                </Address>
                <ConfirmAddress>yes</ConfirmAddress>
              </BuildingSocietyDetails>
            </Account>
          </Payment>
          <OtherInformation/>
          <ThirdParty>no</ThirdParty>
          <Declaration>


            <TextLine>Do you agree to us getting information from any other person or organisation you have told us about as part of this claim? Yes</TextLine>


            <TextLine>This is my claim for Carer's Allowance.</TextLine>
            <TextLine>I understand that if I am paid Carer's Allowance it may affect the benefits paid to Test Middle CaseTwo.</TextLine>
            <TextLine>If the person you are caring for receives certain benefits, the amount they receive may be affected by your claim for Carer's Allowance. Because of this we need both of you to understand the potential consequences of your claim to Carer's Allowance.</TextLine>
            <TextLine>If Test Middle CaseTwo gets a Severe Disability Premium with their income-based Jobseeker's Allowance, Income Support, income-related Employment and Support Allowance, Housing Benefit, they may no longer get that premium if we pay Carer's Allowance to you.</TextLine>
            <TextLine>If Test Middle CaseTwo's Pension Credit includes an extra amount for severe disability, they may no longer get that extra amount if we pay Carer's Allowance to you.</TextLine>
            <TextLine>This could also affect any reduction in Council Tax Test Middle CaseTwo may be entitled to. To find out more about it, please contact the Local Authority.</TextLine>
            <TextLine>We will need to check Test Middle CaseTwo entitlement to Disability Living Allowance, Personal Independence Payment, Attendance Allowance, Constant Attendance Allowance or Armed Forces Independence Payment when considering your claim.</TextLine>
            <TextLine>We may contact Test Middle CaseTwo or their representative to establish whether 35 hours caring per week is taking place.</TextLine>
            <TextLine></TextLine>
            <TextLine>Please tick this box to declare that you have understood the notes and you have made / will make the person you are caring for / or their representative aware that there could be a change to their benefits. = yes</TextLine>

            <TextLine>I declare that I understand the Carer's Allowance Claim Notes and that the information provided on this claim form is correct and complete.</TextLine>
            <TextLine>I understand that I must report all changes in my circumstances or that of the person that I am caring for which may affect my entitlement promptly and by failing to do so I may be liable to prosecution or face a financial penalty.</TextLine>
            <TextLine>I will phone 08456084321 or write to Carer's Allowance Unit, Palatine House, Preston, Lancaster, PR1 1HB to report a change in my circumstances or that of the person that I am caring for.</TextLine>
            <TextLine>If I give false or incomplete information or fail to report changes in my circumstances or that of the person that I am caring for promptly, I understand that my Carer's Allowance may be stopped or reduced and any overpayment of Carer's Allowance may be recovered. In addition I may be prosecuted or face a financial penalty.</TextLine>
            <TextLine>We may wish to contact any current or previous employers, or other persons or organisations you have listed on this claim form to obtain information about your claim. You do not have to agree to this but if you do not, it may mean that we are unable to obtain enough information to satisfy ourselves that you meet the conditions of entitlement for your claim.</TextLine>
            <TextLine></TextLine>
            <TextLine>Please tick this box to confirm that you understand and make the declarations above. = yes</TextLine>
            <TextLine>Please tick this box if this claim form has been filled in by someone else, if so, please ensure that you understand the declarations above as another person cannot make the declarations on your behalf. = yes</TextLine>

            <TextLine>Do you live in Wales and would like to receive future communications in Welsh? No</TextLine>
          </Declaration>
          <EvidenceList>
            <TextLine>
              XML Generated at: 2013-10-16T12:01:48
            </TextLine> <TextLine>
            ======================About You======================
          </TextLine> <TextLine>
            Have you always lived in the UK? = No
          </TextLine> <TextLine>
            Mobile number = 0771 5419808
          </TextLine> <TextLine>
            Are you currently living in the UK? = Yes
          </TextLine> <TextLine>
            When did you arrive in the UK? = 28/09/2012
          </TextLine> <TextLine>
            Do you get state Pension? = No
          </TextLine> <TextLine>
            If you have speech or hearing difficulties, would you like us to contact you by textphone? = Yes
          </TextLine> <TextLine>
            ==================About Your Partner==================
          </TextLine> <TextLine>
            Is your partner/spouse the person you are claiming Carer's Allowance for? = No
          </TextLine> <TextLine>
            ================About Care You Provide================
          </TextLine> <TextLine>
            Do they live at the same address as you? = No
          </TextLine> <TextLine>
            Does this person get Armed Forces Independence Payment? = No
          </TextLine> <TextLine>
            Do you spend 35 hours or more each week caring for this person? = Yes
          </TextLine> <TextLine>
            Did you care for this person for 35 hours or more each week before your claim date ? = No
          </TextLine> <TextLine>
            =====================Time abroad=====================
          </TextLine> <TextLine>
            Do you normally live in the UK, Republic of Ireland, Isle of Man or the Channel Islands? = No
          </TextLine> <TextLine>
            Have you had any more trips out of Great Britain for more than 52 weeks at a time, since 22/03/2013 (this is 156 weeks before your claim date)? = Yes
          </TextLine> <TextLine>
            Have you been out of Great Britain with the person you care for, for more than four weeks at a time, since 22/03/2013 (this is 3 years before your claim date)? = Yes
          </TextLine> <TextLine>
            Where did you go? = Spain
          </TextLine> <TextLine>
            =====================Other Money=====================
          </TextLine> <TextLine>
            Have you
            &lt;
            or your partner/spouse
            &gt;
            claimed or received any other benefits since the date you want to claim? = Yes
          </TextLine> <TextLine>
            Have you received any payments for the person you care for or any other person since your claim date? = Yes
          </TextLine> <TextLine>
            Details about other money: Who pays you? = The Man
          </TextLine> <TextLine>
            Details about other money: How much? = Not much
          </TextLine> <TextLine>
            Details about other money: How often? = Other: Every day and twice on Sundays
          </TextLine> <TextLine>
            Details about other money: How often other? = Every day and twice on Sundays
          </TextLine> <TextLine>
            Statutory Sick Pay: How much? = 123
          </TextLine> <TextLine>
            Statutory Sick Pay: How often? = Other: Every day and twice on Sundays
          </TextLine> <TextLine>
            Statutory Sick Pay: How often other? = Every day and twice on Sundays
          </TextLine> <TextLine>
            Other Statutory Pay: How much? = 120
          </TextLine> <TextLine>
            Other Statutory Pay: How often? = Other: Every day and twice on Sundays
          </TextLine> <TextLine>
            Other Statutory Pay: How often other? = Every day and twice on Sundays
          </TextLine> <TextLine>
            Are you, your wife, husband, civil partner or parent you are dependent on, receiving any pensions or benefits from another EEA State or Switzerland? = Yes
          </TextLine> <TextLine>
            Are you, your wife, husband, civil partner or parent you are dependent on working in or paying insurance to another EEA State or Switzerland? = Yes
          </TextLine>
          </EvidenceList>
        </DWPCAClaim>
      </DWPCATransaction>
    </DWPBody>
  }

  def functionalTestCase3: Elem = {
    <DWPBody xmlns:ds="http://www.w3.org/2000/09/xmldsig#" xmlns="http://www.govtalk.gov.uk/dwp/carers-allowance"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://www.govtalk.gov.uk/dwp/carers-allowance file:/Users/jmi/Temp/CarersAllowance_Schema.xsd">
      <Version>0.1</Version>
      <DWPCATransaction>
        <TransactionId>NFM33DB</TransactionId>
        <DateTimeGenerated>02-10-2010 14:36</DateTimeGenerated>
        <DWPCAClaim id="TEST432">
          <Claimant>
            <DateOfClaim>2010-01-01</DateOfClaim>
            <Surname>CaseThree</Surname>
            <OtherNames>Test Middle</OtherNames>
            <OtherSurnames>Smithson</OtherSurnames>
            <Title>mr</Title>
            <MaritalStatus>m</MaritalStatus>
            <DateOfBirth>1931-01-01</DateOfBirth>
            <NationalInsuranceNumber>JB486278C</NationalInsuranceNumber>
            <ExistingNationalInsuranceNumber/>
            <Address>
              <gds:Line>3 Preston Road</gds:Line> <gds:Line>Preston</gds:Line> <gds:Line>Lancashire</gds:Line> <gds:PostCode>PR1 2TH</gds:PostCode>
            </Address>
            <ConfirmAddress>yes</ConfirmAddress>
            <HomePhoneNumber></HomePhoneNumber>
            <DaytimePhoneNumber>
              <Number>01772 888901</Number>
              <Qualifier/>
            </DaytimePhoneNumber>
            <EmailAddress/>
            <ClaimedBefore>Not asked</ClaimedBefore>
          </Claimant>
          <Caree>
            <Surname>CaseThree</Surname>
            <OtherNames>Test Middle</OtherNames>
            <Title>mrs</Title>
            <DateOfBirth>1937-09-28</DateOfBirth>
            <NationalInsuranceNumber>BA234567A</NationalInsuranceNumber>
            <Address>
              <gds:Line>12 Preston Road</gds:Line> <gds:Line>Preston</gds:Line> <gds:Line>Lancashire</gds:Line> <gds:PostCode>PR1 2TH</gds:PostCode>
            </Address>
            <ConfirmAddress>yes</ConfirmAddress>
            <HomePhoneNumber/>
            <DaytimePhoneNumber>
              <Number>01772 998761</Number>
              <Qualifier/>
            </DaytimePhoneNumber>
            <RelationToClaimant>wife</RelationToClaimant>
            <Cared35hours>Not asked</Cared35hours>
            <CanCareeSign>Not asked</CanCareeSign>
            <CanSomeoneElseSign>Not asked</CanSomeoneElseSign>
            <CanClaimantSign>Not asked</CanClaimantSign>
            <BreaksSinceClaim>yes</BreaksSinceClaim>
            <CareBreak>
              <StartDateTime>2010-01-10T10:00:00</StartDateTime>
              <EndDateTime>2010-01-17T17:00:00</EndDateTime>
              <Reason>At Home</Reason>
              <MedicalCare>yes</MedicalCare>
              <AwayFromHome>Not asked</AwayFromHome>
            </CareBreak> <CareBreak>
            <StartDateTime>2010-01-20T10:00:00</StartDateTime>
            <EndDateTime>2010-01-27T17:00:00</EndDateTime>
            <Reason>Holiday</Reason>
            <MedicalCare>yes</MedicalCare>
            <AwayFromHome>Not asked</AwayFromHome>
          </CareBreak> <CareBreak>
            <StartDateTime>2010-02-20T12:00:00</StartDateTime>
            <EndDateTime>2010-02-27T13:00:00</EndDateTime>
            <Reason>Respite Care</Reason>
            <MedicalCare>yes</MedicalCare>
            <AwayFromHome>Not asked</AwayFromHome>
          </CareBreak> <CareBreak>
            <StartDateTime>2010-03-20T12:00:00</StartDateTime>
            <EndDateTime>2010-02-21T13:00:00</EndDateTime>
            <Reason>Holiday</Reason>
            <MedicalCare>yes</MedicalCare>
            <AwayFromHome>Not asked</AwayFromHome>
          </CareBreak> <CareBreak>
            <StartDateTime>2013-03-20T12:15:00</StartDateTime>
            <EndDateTime>2013-02-21T13:15:00</EndDateTime>
            <Reason>Other</Reason>
            <MedicalCare>no</MedicalCare>
            <AwayFromHome>Not asked</AwayFromHome>
          </CareBreak>
            <Cared35hoursBefore>Not asked</Cared35hoursBefore>


            <PaidForCaring>Not asked</PaidForCaring>
            <ClaimedPreviously>Not asked</ClaimedPreviously>
          </Caree>
          <ClaimADI>no</ClaimADI>
          <Residency>
            <Nationality>British</Nationality>
            <EUEEASwissNational>Not asked</EUEEASwissNational>
            <CountryNormallyLive>Not asked</CountryNormallyLive>
            <CountryNormallyLiveOther>Not asked</CountryNormallyLiveOther>
            <InGreatBritainNow>yes</InGreatBritainNow>
            <InGreatBritain26Weeks>Not asked</InGreatBritain26Weeks>
            <PeriodAbroadLastYear>
              <Period>
                <DateFrom>2013-05-31</DateFrom>
                <DateTo>2013-06-09</DateTo>
              </Period>
              <Reason>Holiday</Reason>
              <Country>Spain</Country>
            </PeriodAbroadLastYear> <PeriodAbroadLastYear>
            <Period>
              <DateFrom>2013-06-11</DateFrom>
              <DateTo>2013-06-19</DateTo>
            </Period>
            <Reason>Holiday</Reason>
            <Country>France</Country>
          </PeriodAbroadLastYear> <PeriodAbroadLastYear>
            <Period>
              <DateFrom>2013-01-01</DateFrom>
              <DateTo>2013-01-09</DateTo>
            </Period>
            <Reason>Holiday</Reason>
            <Country>Scotland</Country>
          </PeriodAbroadLastYear> <PeriodAbroadLastYear>
            <Period>
              <DateFrom>2013-03-01</DateFrom>
              <DateTo>2013-03-05</DateTo>
            </Period>
            <Reason>Holiday</Reason>
            <Country>Northumberland</Country>
          </PeriodAbroadLastYear> <PeriodAbroadLastYear>
            <Period>
              <DateFrom>2013-03-31</DateFrom>
              <DateTo>2013-04-04</DateTo>
            </Period>
            <Reason>Easter break</Reason>
            <Country>London</Country>
          </PeriodAbroadLastYear>
            <BritishOverseasPassport>Not asked</BritishOverseasPassport>

            <OutOfGreatBritain>Not asked</OutOfGreatBritain>
            <PeriodAbroadDuringCare>
              <Period>
                <DateFrom>2012-05-31</DateFrom>
                <DateTo>2012-06-01</DateTo>
              </Period>
              <Reason>Long holiday</Reason>
            </PeriodAbroadDuringCare> <PeriodAbroadDuringCare>
            <Period>
              <DateFrom>2012-06-04</DateFrom>
              <DateTo>2012-06-08</DateTo>
            </Period>
            <Reason>Long holiday</Reason>
          </PeriodAbroadDuringCare> <PeriodAbroadDuringCare>
            <Period>
              <DateFrom>2012-06-14</DateFrom>
              <DateTo>2012-06-18</DateTo>
            </Period>
            <Reason>Long holiday</Reason>
          </PeriodAbroadDuringCare>
          </Residency>
          <CourseOfEducation>no</CourseOfEducation>

          <SelfEmployed>yes</SelfEmployed>
          <SelfEmployment>
            <SelfEmployedNow>yes</SelfEmployedNow>
            <CurrentJobDetails>
              <DateStarted>2010-02-01</DateStarted>
              <NatureOfBusiness>Fruit and veg, delivery service</NatureOfBusiness>
              <TradingYear>
                <DateFrom>2012-02-01</DateFrom>
                <DateTo>2013-01-31</DateTo>
              </TradingYear>
            </CurrentJobDetails>
            <Accountant>
              <HasAccountant>Not asked</HasAccountant>
              <ContactAccountant>Not asked</ContactAccountant>
            </Accountant>
            <CareExpensesChildren>yes</CareExpensesChildren>
            <ChildCareExpenses>
              <CarerName>Mr John Smith</CarerName>
              <CarerAddress>
                <gds:Line></gds:Line> <gds:Line></gds:Line> <gds:Line></gds:Line> <gds:PostCode></gds:PostCode>
              </CarerAddress>
              <ConfirmAddress>yes</ConfirmAddress>
              <WeeklyPayment>
                <Currency></Currency>
                <Amount>Not asked</Amount>
              </WeeklyPayment>
              <RelationshipCarerToClaimant>uncle</RelationshipCarerToClaimant>
              <ChildDetails>
                <Name>Not asked</Name>
                <RelationToChild>aunt</RelationToChild>
              </ChildDetails>
            </ChildCareExpenses>
            <CareExpensesCaree>yes</CareExpensesCaree>
            <CareExpenses>
              <CarerName>Mrs Terry Smith</CarerName>
              <CarerAddress>
                <gds:Line></gds:Line> <gds:Line></gds:Line> <gds:Line></gds:Line> <gds:PostCode></gds:PostCode>
              </CarerAddress>
              <ConfirmAddress>yes</ConfirmAddress>
              <WeeklyPayment>
                <Currency></Currency>
                <Amount>Not asked</Amount>
              </WeeklyPayment>
              <RelationshipCarerToClaimant>aunt</RelationshipCarerToClaimant>
              <RelationshipCarerToCaree>aunt</RelationshipCarerToCaree>
            </CareExpenses>
            <PaidForPension>no</PaidForPension>

          </SelfEmployment>
          <Employed>yes</Employed>
          <Employment>
            <CurrentlyEmployed>no</CurrentlyEmployed>
            <DateLastWorked>Not asked</DateLastWorked>
            <JobDetails>
              <Employer>
                <DateJobStarted>2013-01-01</DateJobStarted>
                <DateJobEnded>2013-07-01</DateJobEnded>
                <JobType>Hacker</JobType>
                <ClockPayrollNumber>12345678</ClockPayrollNumber>
                <Name>Tesco's</Name>
                <Address>
                  <gds:Line>23 Yeadon Way</gds:Line> <gds:Line>Blackpool</gds:Line> <gds:Line>Lancashire</gds:Line> <gds:PostCode>FY4 5TH</gds:PostCode>
                </Address>
                <ConfirmAddress>yes</ConfirmAddress> <!-- Always default to yes -->
                <EmployersPhoneNumber>01253 667889</EmployersPhoneNumber>
                <EmployersFaxNumber/>
                <WagesDepartment/>
                <DepartmentPhoneFaxNumber/>
              </Employer>
              <Pay>
                <WeeklyHoursWorked>25</WeeklyHoursWorked>
                <DateLastWorked/>
                <DateLastPaid/>
                <GrossPayment>
                  <Currency>GBP</Currency>
                  <Amount>600</Amount>
                </GrossPayment>
                <IncludedInWage>All amounts due</IncludedInWage>
                <PayPeriod>
                  <DateFrom></DateFrom>
                  <DateTo></DateTo>
                </PayPeriod>
                <PayFrequency>Four-weekly</PayFrequency> <PayFrequencyOther/>
                <UsualPayDay>two weeks ago</UsualPayDay>
                <VaryingEarnings>Not asked</VaryingEarnings>
              </Pay>
              <OtherThanMoney>Not asked</OtherThanMoney>
              <OweMoney>yes</OweMoney>
              <CareExpensesChildren>yes</CareExpensesChildren> <ChildCareExpenses>
              <CarerName>Mr Grandfather Senior</CarerName>
              <CarerAddress>
                <gds:Line>Not asked</gds:Line> <gds:Line>Not asked</gds:Line> <gds:Line>Not asked</gds:Line> <gds:PostCode></gds:PostCode>
              </CarerAddress>
              <ConfirmAddress>yes</ConfirmAddress>
              <WeeklyPayment>
                <Currency></Currency>
                <Amount>Not asked</Amount>
              </WeeklyPayment>
              <RelationshipCarerToClaimant>father</RelationshipCarerToClaimant>
              <ChildDetails>
                <Name>Not asked</Name>
                <RelationToChild>grandFather</RelationToChild>
              </ChildDetails>
            </ChildCareExpenses>
              <CareExpensesCaree>yes</CareExpensesCaree> <CareExpenses>
              <CarerName>Carers UK Ltd</CarerName>
              <CarerAddress>
                <gds:Line>Not asked</gds:Line> <gds:Line>Not asked</gds:Line> <gds:Line>Not asked</gds:Line> <gds:PostCode></gds:PostCode>
              </CarerAddress>
              <ConfirmAddress>yes</ConfirmAddress>
              <WeeklyPayment>
                <Currency></Currency>
                <Amount>Not asked</Amount>
              </WeeklyPayment>
              <RelationshipCarerToClaimant>uncle</RelationshipCarerToClaimant>
              <RelationshipCarerToCaree>other</RelationshipCarerToCaree>
            </CareExpenses>
              <PaidForOccupationalPension>yes</PaidForOccupationalPension> <PensionScheme>
              <Type>occupational</Type>
              <Payment>
                <Currency>GBP</Currency>
                <Amount>350.1</Amount>
              </Payment>
              <Frequency>other</Frequency>
            </PensionScheme> <PaidForPersonalPension>yes</PaidForPersonalPension> <PensionScheme>
              <Type>personal_private</Type>
              <Payment>
                <Currency>GBP</Currency>
                <Amount>200.1</Amount>
              </Payment>
              <Frequency>other</Frequency>
            </PensionScheme>
              <PaidForJobExpenses>yes</PaidForJobExpenses> <JobExpenses>
              <Expense>Petrol money for driving</Expense>
              <Reason>Not asked</Reason>
              <WeeklyPayment>
                <Currency></Currency>
                <Amount>Not asked</Amount>
              </WeeklyPayment>
            </JobExpenses>
            </JobDetails> <JobDetails>
            <Employer>
              <DateJobStarted>2013-01-01</DateJobStarted>
              <DateJobEnded/>
              <JobType>Hacker</JobType>
              <ClockPayrollNumber>12345678</ClockPayrollNumber>
              <Name>Tesco's</Name>
              <Address>
                <gds:Line>23 Yeadon Way</gds:Line> <gds:Line>Blackpool</gds:Line> <gds:Line>Lancashire</gds:Line> <gds:PostCode>FY4 5TH</gds:PostCode>
              </Address>
              <ConfirmAddress>yes</ConfirmAddress> <!-- Always default to yes -->
              <EmployersPhoneNumber>01253 667889</EmployersPhoneNumber>
              <EmployersFaxNumber/>
              <WagesDepartment/>
              <DepartmentPhoneFaxNumber/>
            </Employer>
            <Pay>

              <DateLastWorked/>
              <DateLastPaid>2013-07-08</DateLastPaid>
              <GrossPayment>
                <Currency>GBP</Currency>
                <Amount>600</Amount>
              </GrossPayment>
              <IncludedInWage/>
              <PayPeriod>
                <DateFrom></DateFrom>
                <DateTo></DateTo>
              </PayPeriod>
              <PayFrequency/>
              <PayFrequencyOther/>
              <UsualPayDay>Not asked</UsualPayDay>
              <VaryingEarnings>Not asked</VaryingEarnings>
            </Pay>
            <OtherThanMoney>Not asked</OtherThanMoney>
            <OweMoney>yes</OweMoney>
            <CareExpensesChildren>yes</CareExpensesChildren> <ChildCareExpenses>
              <CarerName>Mr Grandfather Senior</CarerName>
              <CarerAddress>
                <gds:Line>Not asked</gds:Line> <gds:Line>Not asked</gds:Line> <gds:Line>Not asked</gds:Line> <gds:PostCode></gds:PostCode>
              </CarerAddress>
              <ConfirmAddress>yes</ConfirmAddress>
              <WeeklyPayment>
                <Currency></Currency>
                <Amount>Not asked</Amount>
              </WeeklyPayment>
              <RelationshipCarerToClaimant>father</RelationshipCarerToClaimant>
              <ChildDetails>
                <Name>Not asked</Name>
                <RelationToChild>grandFather</RelationToChild>
              </ChildDetails>
            </ChildCareExpenses>
            <CareExpensesCaree>yes</CareExpensesCaree> <CareExpenses>
              <CarerName>Age Concern K Ltd</CarerName>
              <CarerAddress>
                <gds:Line>Not asked</gds:Line> <gds:Line>Not asked</gds:Line> <gds:Line>Not asked</gds:Line> <gds:PostCode></gds:PostCode>
              </CarerAddress>
              <ConfirmAddress>yes</ConfirmAddress>
              <WeeklyPayment>
                <Currency></Currency>
                <Amount>Not asked</Amount>
              </WeeklyPayment>
              <RelationshipCarerToClaimant>other</RelationshipCarerToClaimant>
              <RelationshipCarerToCaree>other</RelationshipCarerToCaree>
            </CareExpenses>
            <PaidForOccupationalPension>yes</PaidForOccupationalPension> <PensionScheme>
              <Type>occupational</Type>
              <Payment>
                <Currency>GBP</Currency>
                <Amount>120.03</Amount>
              </Payment>
              <Frequency>03</Frequency>
            </PensionScheme> <PaidForPersonalPension>yes</PaidForPersonalPension> <PensionScheme>
              <Type>personal_private</Type>
              <Payment>
                <Currency>GBP</Currency>
                <Amount>345.2</Amount>
              </Payment>
              <Frequency>03</Frequency>
            </PensionScheme>
            <PaidForJobExpenses>yes</PaidForJobExpenses> <JobExpenses>
              <Expense>Petrol money for driving</Expense>
              <Reason>Not asked</Reason>
              <WeeklyPayment>
                <Currency></Currency>
                <Amount>Not asked</Amount>
              </WeeklyPayment>
            </JobExpenses>
          </JobDetails>
          </Employment>
          <PropertyRentedOut>
            <PayNationalInsuranceContributions/>
            <RentOutProperty>Not asked</RentOutProperty>
            <SubletHome>Not asked</SubletHome>
          </PropertyRentedOut>
          <HavePartner>yes</HavePartner>
          <Partner>
            <NationalityPartner>British</NationalityPartner>
            <Surname>CaseThree</Surname>
            <OtherNames>Test Middle</OtherNames>
            <OtherSurnames>Dixon</OtherSurnames>
            <Title>mrs</Title>
            <DateOfBirth>1937-09-28</DateOfBirth>
            <NationalInsuranceNumber>BA234567A</NationalInsuranceNumber>
            <Address>
              <gds:Line>Not asked</gds:Line> <gds:Line></gds:Line> <gds:Line></gds:Line> <gds:PostCode></gds:PostCode>
            </Address>
            <ConfirmAddress>yes</ConfirmAddress>
            <RelationshipStatus>
              <JoinedHouseholdAfterDateOfClaim>Not asked</JoinedHouseholdAfterDateOfClaim>
              <JoinedHouseholdDate></JoinedHouseholdDate>
              <SeparatedFromPartner>no</SeparatedFromPartner>
              <SeparationDate></SeparationDate>
            </RelationshipStatus>
          </Partner>
          <OtherBenefits>
            <ClaimantBenefits>
              <JobseekersAllowance>no</JobseekersAllowance>
              <IncomeSupport>no</IncomeSupport>
              <PensionCredit>no</PensionCredit>
              <StatePension>no</StatePension>
              <IncapacityBenefit>no</IncapacityBenefit>
              <SevereDisablementAllowance>no</SevereDisablementAllowance>
              <MaternityAllowance>no</MaternityAllowance>
              <UnemployabilitySupplement>no</UnemployabilitySupplement>
              <WindowsBenefit>no</WindowsBenefit>
              <WarWidowsPension>no</WarWidowsPension>
              <IndustrialDeathBenefit>no</IndustrialDeathBenefit>
              <GovernmentTrainingAllowance>no</GovernmentTrainingAllowance>
              <LoneParentChildBenefit>no</LoneParentChildBenefit>
              <OtherSocialSecurityBenefit>Not asked</OtherSocialSecurityBenefit>
              <NonSocialSecurityBenefit>Not asked</NonSocialSecurityBenefit>
              <NoBenefits>Not asked</NoBenefits>
            </ClaimantBenefits>
            <PartnerBenefits>
              <JobseekersAllowance>no</JobseekersAllowance>
              <IncomeSupport>no</IncomeSupport>
              <PensionCredit>no</PensionCredit>
              <StatePension>no</StatePension>
              <IncapacityBenefit>no</IncapacityBenefit>
              <SevereDisablementAllowance>no</SevereDisablementAllowance>
              <MaternityAllowance>no</MaternityAllowance>
              <UnemployabilitySupplement>no</UnemployabilitySupplement>
              <WindowsBenefit>no</WindowsBenefit>
              <WarWidowsPension>no</WarWidowsPension>
              <IndustrialDeathBenefit>no</IndustrialDeathBenefit>
              <GovernmentTrainingAllowance>no</GovernmentTrainingAllowance>
              <OtherSocialSecurityBenefit>Not asked</OtherSocialSecurityBenefit>
              <NonSocialSecurityBenefit>Not asked</NonSocialSecurityBenefit>
              <NoBenefits>Not asked</NoBenefits>
            </PartnerBenefits>
            <ExtraMoney>Not asked</ExtraMoney>
            <OtherMoneySSP>no</OtherMoneySSP>
            <OtherMoneySMP>yes</OtherMoneySMP> <OtherMoneySMPDetails>
            <Name>Greggs Bakers</Name>
            <Address>
              <gds:Line>1012 Preston Road</gds:Line> <gds:Line>Preston</gds:Line> <gds:Line>Lancashure</gds:Line> <gds:PostCode>PR45 6YH</gds:PostCode>
            </Address>
            <ConfirmAddress>yes</ConfirmAddress>
          </OtherMoneySMPDetails>
          </OtherBenefits>
          <Payment>
            <PaymentFrequency>fourWeekly</PaymentFrequency>
            <InitialAccountQuestion>notOpenAccount</InitialAccountQuestion>

          </Payment>
          <OtherInformation/>
          <ThirdParty>no</ThirdParty>
          <Declaration>
            <TextLine>Do you agree to us getting information from any current or previous employer you have told us about as part of this claim? Yes</TextLine>


            <TextLine>Do you agree to us getting information from any other person or organisation you have told us about as part of this claim? Yes</TextLine>


            <TextLine>This is my claim for Carer's Allowance.</TextLine>
            <TextLine>I understand that if I am paid Carer's Allowance it may affect the benefits paid to Test Middle CaseThree.</TextLine>
            <TextLine>If the person you are caring for receives certain benefits, the amount they receive may be affected by your claim for Carer's Allowance. Because of this we need both of you to understand the potential consequences of your claim to Carer's Allowance.</TextLine>
            <TextLine>If Test Middle CaseThree gets a Severe Disability Premium with their income-based Jobseeker's Allowance, Income Support, income-related Employment and Support Allowance, Housing Benefit, they may no longer get that premium if we pay Carer's Allowance to you.</TextLine>
            <TextLine>If Test Middle CaseThree's Pension Credit includes an extra amount for severe disability, they may no longer get that extra amount if we pay Carer's Allowance to you.</TextLine>
            <TextLine>This could also affect any reduction in Council Tax Test Middle CaseThree may be entitled to. To find out more about it, please contact the Local Authority.</TextLine>
            <TextLine>We will need to check Test Middle CaseThree entitlement to Disability Living Allowance, Personal Independence Payment, Attendance Allowance, Constant Attendance Allowance or Armed Forces Independence Payment when considering your claim.</TextLine>
            <TextLine>We may contact Test Middle CaseThree or their representative to establish whether 35 hours caring per week is taking place.</TextLine>
            <TextLine></TextLine>
            <TextLine>Please tick this box to declare that you have understood the notes and you have made / will make the person you are caring for / or their representative aware that there could be a change to their benefits. = yes</TextLine>

            <TextLine>I declare that I understand the Carer's Allowance Claim Notes and that the information provided on this claim form is correct and complete.</TextLine>
            <TextLine>I understand that I must report all changes in my circumstances or that of the person that I am caring for which may affect my entitlement promptly and by failing to do so I may be liable to prosecution or face a financial penalty.</TextLine>
            <TextLine>I will phone 08456084321 or write to Carer's Allowance Unit, Palatine House, Preston, Lancaster, PR1 1HB to report a change in my circumstances or that of the person that I am caring for.</TextLine>
            <TextLine>If I give false or incomplete information or fail to report changes in my circumstances or that of the person that I am caring for promptly, I understand that my Carer's Allowance may be stopped or reduced and any overpayment of Carer's Allowance may be recovered. In addition I may be prosecuted or face a financial penalty.</TextLine>
            <TextLine>We may wish to contact any current or previous employers, or other persons or organisations you have listed on this claim form to obtain information about your claim. You do not have to agree to this but if you do not, it may mean that we are unable to obtain enough information to satisfy ourselves that you meet the conditions of entitlement for your claim.</TextLine>
            <TextLine></TextLine>
            <TextLine>Please tick this box to confirm that you understand and make the declarations above. = yes</TextLine>
            <TextLine>Please tick this box if this claim form has been filled in by someone else, if so, please ensure that you understand the declarations above as another person cannot make the declarations on your behalf. = yes</TextLine>

            <TextLine>Do you live in Wales and would like to receive future communications in Welsh? No</TextLine>
          </Declaration>
          <EvidenceList>
            <TextLine>
              XML Generated at: 2013-10-16T12:19:23
            </TextLine> <TextLine>
            Send us the following documents below including your Name and National Insurance (NI) number.
          </TextLine> <TextLine/> <TextLine>
            Your Employment documents.
          </TextLine> <TextLine>
            Last payslip you got before your claim date: 01/01/2010
          </TextLine> <TextLine>
            Any payslips you have had since then.
          </TextLine> <TextLine>
            Any pension statements you may have.
          </TextLine> <TextLine/> <TextLine>
            Your Self-employed documents.
          </TextLine> <TextLine>
            Most recent finalised accounts you have for your business.
          </TextLine> <TextLine>
            Any pension statements you may have.
          </TextLine> <TextLine/> <TextLine>
            Send the above documents to:
          </TextLine> <TextLine>
            CA Freepost
          </TextLine> <TextLine>
            Palatine House
          </TextLine> <TextLine>
            Preston
          </TextLine> <TextLine>
            PR1 1HN
          </TextLine> <TextLine>
            The Carer's Allowance unit will contact you if they need any further information.
          </TextLine> <TextLine/> <TextLine>
            ======================About You======================
          </TextLine> <TextLine>
            Have you always lived in the UK? = No
          </TextLine> <TextLine>
            Mobile number = 0771 5419808
          </TextLine> <TextLine>
            Are you currently living in the UK? = No
          </TextLine> <TextLine>
            Do you get state Pension? = No
          </TextLine> <TextLine/> <TextLine>
            ==================About Your Partner==================
          </TextLine> <TextLine>
            Is your partner/spouse the person you are claiming Carer's Allowance for? = Yes
          </TextLine> <TextLine>
            ================About Care You Provide================
          </TextLine> <TextLine>
            Do they live at the same address as you? = No
          </TextLine> <TextLine>
            Does this person get Armed Forces Independence Payment? = No
          </TextLine> <TextLine>
            Do you spend 35 hours or more each week caring for this person? = Yes
          </TextLine> <TextLine>
            Did you care for this person for 35 hours or more each week before your claim date ? = No
          </TextLine> <TextLine/> <TextLine>
            Where was the person you care for during the break? = Hospital
          </TextLine> <TextLine/>
            <TextLine/> <TextLine>
            Where was the person you care for during the break? = Nursing Home
          </TextLine> <TextLine/>
            <TextLine/> <TextLine>
            Where was the person you care for during the break? = Care Home
          </TextLine> <TextLine/>
            <TextLine/> <TextLine>
            Where was the person you care for during the break? = Nursing Home
          </TextLine> <TextLine/> <TextLine>
            Where were you during the break? Other detail = Other text
          </TextLine> <TextLine>
            Where was the person you care for during the break? = Other
          </TextLine> <TextLine>
            Where was the person you care for during the break? Other detail = Other text
          </TextLine> <TextLine>
            =====================Time abroad=====================
          </TextLine> <TextLine>
            Do you normally live in the UK, Republic of Ireland, Isle of Man or the Channel Islands? = Yes
          </TextLine> <TextLine>
            Have you had any more trips out of Great Britain for more than 52 weeks at a time, since 01/01/2010 (this is 156 weeks before your claim date)? = Yes
          </TextLine> <TextLine>
            Have you been out of Great Britain with the person you care for, for more than four weeks at a time, since 01/01/2010 (this is 3 years before your claim date)? = Yes
          </TextLine> <TextLine>
            Where did you go? = Bangor
          </TextLine> <TextLine>
            Where did you go? = Spain
          </TextLine> <TextLine>
            Where did you go? = USA
          </TextLine> <TextLine>
            ======================Employment======================
          </TextLine> <TextLine>
            Employer:Tesco's
          </TextLine> <TextLine>
            How much [[past=did you]] [[present=do you]] pay them - expenses related to childcare expenses? = 120.12
          </TextLine> <TextLine>
            How often [[past=did you]] [[present=do you]] - expenses related to childcare expenses? = Other
          </TextLine> <TextLine>
            How often [[past=did you]] [[present=do you]] Other - expenses related to childcare expenses? = Quaterly
          </TextLine> <TextLine>
            How much [[past=did you]] [[present=do you]] pay them - expenses related to person you care for? = 150.55
          </TextLine> <TextLine>
            How often [[past=did you]] [[present=do you]] - expenses related to the person you care for? = Other
          </TextLine> <TextLine>
            How often [[past=did you]] [[present=do you]] Other - expenses related to the person you care for? = Annually
          </TextLine> <TextLine>
            How often other - Occupational Pension Scheme? = Other frequency fo occupational scheme
          </TextLine> <TextLine>
            How often other - Personal Pension Scheme? = Another reason
          </TextLine> <TextLine>
            Employer:Tesco's
          </TextLine> <TextLine>
            What is the leaving date on your P45, if you have one? = 25/12/2010
          </TextLine> <TextLine>
            About your wage,[[past=Did you]] [[present=Do you]] get the same amount each time? = No
          </TextLine> <TextLine>
            How much [[past=did you]] [[present=do you]] pay them - expenses related to childcare expenses? = 120.12
          </TextLine> <TextLine>
            How often [[past=did you]] [[present=do you]] - expenses related to childcare expenses? = Weekly
          </TextLine> <TextLine>
            How much [[past=did you]] [[present=do you]] pay them - expenses related to person you care for? = 150.20
          </TextLine> <TextLine>
            How often [[past=did you]] [[present=do you]] - expenses related to the person you care for? = Fortnightly
          </TextLine> <TextLine>
            ===================Self Employment===================
          </TextLine> <TextLine>
            Are the income, outgoings and profit in these accounts similar to your current level of trading? = No
          </TextLine> <TextLine>
            Please tell us why and when the change happened = Depends on the seasons, and productivity of the fruit.
          </TextLine> <TextLine>
            How much [[past=did you]] [[present=do you]] pay them - expenses related to childcare? = 120
          </TextLine> <TextLine>
            How often [[past=did you]] [[present=do you]] - expenses related to childcare expenses? = Weekly
          </TextLine> <TextLine>
            How much [[past=did you]] [[present=do you]] pay them - expenses related to person you care for? = 450
          </TextLine> <TextLine>
            How often [[past=did you]] [[present=do you]] - expenses related to person you care for? = Other
          </TextLine> <TextLine>
            How often [[past=did you]] [[present=do you]] Other - expenses related to person you care for? = Other expenses frequency
          </TextLine> <TextLine>
            =====================Other Money=====================
          </TextLine> <TextLine>
            Have you
            &lt;
            or your partner/spouse
            &gt;
            claimed or received any other benefits since the date you want to claim? = Yes
          </TextLine> <TextLine>
            Have you received any payments for the person you care for or any other person since your claim date? = No
          </TextLine> <TextLine/>
            <TextLine/>
            <TextLine/>
            <TextLine/>
            <TextLine/>
            <TextLine/>
            <TextLine/> <TextLine>
            Other Statutory Pay: How much? = 145
          </TextLine> <TextLine>
            Other Statutory Pay: How often? = Monthly
          </TextLine> <TextLine/> <TextLine>
            Are you, your wife, husband, civil partner or parent you are dependent on, receiving any pensions or benefits from another EEA State or Switzerland? = No
          </TextLine> <TextLine>
            Are you, your wife, husband, civil partner or parent you are dependent on working in or paying insurance to another EEA State or Switzerland? = No
          </TextLine>
          </EvidenceList>
        </DWPCAClaim>
      </DWPCATransaction>
    </DWPBody>
  }

  def functionalTestCase4: Elem = {
    <DWPBody xmlns:ds="http://www.w3.org/2000/09/xmldsig#" xmlns="http://www.govtalk.gov.uk/dwp/carers-allowance"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://www.govtalk.gov.uk/dwp/carers-allowance file:/Users/jmi/Temp/CarersAllowance_Schema.xsd">
      <Version>0.1</Version>
      <DWPCATransaction>
        <TransactionId>NFM33DB</TransactionId>
        <DateTimeGenerated>02-10-2010 14:36</DateTimeGenerated>
        <DWPCAClaim id="TEST432">
          <Claimant>
            <DateOfClaim>2013-01-05</DateOfClaim>
            <Surname>CaseFour</Surname>
            <OtherNames>Test Middle</OtherNames>
            <OtherSurnames>Thornhill</OtherSurnames>
            <Title>mr</Title>
            <MaritalStatus>m</MaritalStatus>
            <DateOfBirth>1951-01-01</DateOfBirth>
            <NationalInsuranceNumber>JB486248C</NationalInsuranceNumber>
            <ExistingNationalInsuranceNumber/>
            <Address>
              <gds:Line>4 Preston Road</gds:Line> <gds:Line>Preston</gds:Line> <gds:Line>Lancashire</gds:Line> <gds:PostCode>PR1 2TH</gds:PostCode>
            </Address>
            <ConfirmAddress>yes</ConfirmAddress>
            <HomePhoneNumber></HomePhoneNumber>
            <DaytimePhoneNumber>
              <Number>01772 888901</Number>
              <Qualifier/>
            </DaytimePhoneNumber>
            <EmailAddress/>
            <ClaimedBefore>Not asked</ClaimedBefore>
          </Claimant>
          <Caree>
            <Surname>watson</Surname>
            <OtherNames>Cloe scott</OtherNames>
            <Title>dame</Title>
            <DateOfBirth>1951-07-03</DateOfBirth>
            <NationalInsuranceNumber></NationalInsuranceNumber>
            <Address>
              <gds:Line>12 Preston Road</gds:Line> <gds:Line>Preston</gds:Line> <gds:Line>Lancashire</gds:Line> <gds:PostCode>PR1 1HB</gds:PostCode>
            </Address>
            <ConfirmAddress>yes</ConfirmAddress>
            <HomePhoneNumber/>
            <DaytimePhoneNumber>
              <Number></Number>
              <Qualifier/>
            </DaytimePhoneNumber>
            <RelationToClaimant>mother</RelationToClaimant>
            <Cared35hours>Not asked</Cared35hours>
            <CanCareeSign>Not asked</CanCareeSign>
            <CanSomeoneElseSign>Not asked</CanSomeoneElseSign>
            <CanClaimantSign>Not asked</CanClaimantSign>
            <BreaksSinceClaim>yes</BreaksSinceClaim>
            <CareBreak>
              <StartDateTime>2010-07-10T10:00:00</StartDateTime>
              <EndDateTime>2010-08-17T17:45:00</EndDateTime>
              <Reason>At Home</Reason>
              <MedicalCare>yes</MedicalCare>
              <AwayFromHome>Not asked</AwayFromHome>
            </CareBreak>
            <Cared35hoursBefore>Not asked</Cared35hoursBefore>
            <DateStartedCaring>2010-05-01</DateStartedCaring>
            <BreaksBeforeClaim>yes</BreaksBeforeClaim>
            <PaidForCaring>Not asked</PaidForCaring>
            <ClaimedPreviously>Not asked</ClaimedPreviously>
          </Caree>
          <ClaimADI>no</ClaimADI>
          <Residency>
            <Nationality>British</Nationality>
            <EUEEASwissNational>Not asked</EUEEASwissNational>
            <CountryNormallyLive>Not asked</CountryNormallyLive>
            <CountryNormallyLiveOther>Not asked</CountryNormallyLiveOther>
            <InGreatBritainNow>yes</InGreatBritainNow>
            <InGreatBritain26Weeks>Not asked</InGreatBritain26Weeks>

            <BritishOverseasPassport>Not asked</BritishOverseasPassport>

            <OutOfGreatBritain>Not asked</OutOfGreatBritain>

          </Residency>
          <CourseOfEducation>no</CourseOfEducation>

          <SelfEmployed>yes</SelfEmployed>
          <SelfEmployment>
            <SelfEmployedNow>yes</SelfEmployedNow>
            <CurrentJobDetails>
              <DateStarted>2010-02-01</DateStarted>
              <NatureOfBusiness>Fruit and veg, delivery service</NatureOfBusiness>
              <TradingYear>
                <DateFrom>2012-02-01</DateFrom>
                <DateTo>2013-01-31</DateTo>
              </TradingYear>
            </CurrentJobDetails>
            <Accountant>
              <HasAccountant>Not asked</HasAccountant>
              <ContactAccountant>Not asked</ContactAccountant>
            </Accountant>
            <CareExpensesChildren>yes</CareExpensesChildren>
            <ChildCareExpenses>
              <CarerName>Mr John Johnson</CarerName>
              <CarerAddress>
                <gds:Line></gds:Line> <gds:Line></gds:Line> <gds:Line></gds:Line> <gds:PostCode></gds:PostCode>
              </CarerAddress>
              <ConfirmAddress>yes</ConfirmAddress>
              <WeeklyPayment>
                <Currency></Currency>
                <Amount>Not asked</Amount>
              </WeeklyPayment>
              <RelationshipCarerToClaimant>brother</RelationshipCarerToClaimant>
              <ChildDetails>
                <Name>Not asked</Name>
                <RelationToChild>stepBrother</RelationToChild>
              </ChildDetails>
            </ChildCareExpenses>
            <CareExpensesCaree>yes</CareExpensesCaree>
            <CareExpenses>
              <CarerName>Mrs Terry Thornhill</CarerName>
              <CarerAddress>
                <gds:Line></gds:Line> <gds:Line></gds:Line> <gds:Line></gds:Line> <gds:PostCode></gds:PostCode>
              </CarerAddress>
              <ConfirmAddress>yes</ConfirmAddress>
              <WeeklyPayment>
                <Currency></Currency>
                <Amount>Not asked</Amount>
              </WeeklyPayment>
              <RelationshipCarerToClaimant>aunt</RelationshipCarerToClaimant>
              <RelationshipCarerToCaree>adoptedSon</RelationshipCarerToCaree>
            </CareExpenses>
            <PaidForPension>yes</PaidForPension>
            <PensionScheme>
              <Type>personal_private</Type>
              <Payment>
                <Currency>GBP</Currency> <Amount>100</Amount>
              </Payment>
              <Frequency>02</Frequency>
            </PensionScheme>
          </SelfEmployment>
          <Employed>yes</Employed>
          <Employment>
            <CurrentlyEmployed>yes</CurrentlyEmployed>
            <DateLastWorked>Not asked</DateLastWorked>
            <JobDetails>
              <Employer>
                <DateJobStarted>2013-01-01</DateJobStarted>
                <DateJobEnded/>
                <JobType>Hacker</JobType>
                <ClockPayrollNumber>12345678</ClockPayrollNumber>
                <Name>Tesco's Bank</Name>
                <Address>
                  <gds:Line>23 Yeadon Way</gds:Line> <gds:Line>Blackpool</gds:Line> <gds:Line>Lancashire</gds:Line> <gds:PostCode>FY4 5TH</gds:PostCode>
                </Address>
                <ConfirmAddress>yes</ConfirmAddress> <!-- Always default to yes -->
                <EmployersPhoneNumber>01253 667889</EmployersPhoneNumber>
                <EmployersFaxNumber/>
                <WagesDepartment/>
                <DepartmentPhoneFaxNumber/>
              </Employer>
              <Pay>
                <WeeklyHoursWorked>25</WeeklyHoursWorked>
                <DateLastWorked/>
                <DateLastPaid>2013-07-08</DateLastPaid>
                <GrossPayment>
                  <Currency>GBP</Currency>
                  <Amount>340</Amount>
                </GrossPayment>
                <IncludedInWage>All amounts due</IncludedInWage>
                <PayPeriod>
                  <DateFrom></DateFrom>
                  <DateTo></DateTo>
                </PayPeriod>
                <PayFrequency>Other</PayFrequency> <PayFrequencyOther>Other Frequency</PayFrequencyOther>
                <UsualPayDay>two weeks ago</UsualPayDay>
                <VaryingEarnings>Not asked</VaryingEarnings>
              </Pay>
              <OtherThanMoney>Not asked</OtherThanMoney>
              <OweMoney>no</OweMoney>
              <CareExpensesChildren>yes</CareExpensesChildren> <ChildCareExpenses>
              <CarerName>Mr Grandfather Senior</CarerName>
              <CarerAddress>
                <gds:Line>Not asked</gds:Line> <gds:Line>Not asked</gds:Line> <gds:Line>Not asked</gds:Line> <gds:PostCode></gds:PostCode>
              </CarerAddress>
              <ConfirmAddress>yes</ConfirmAddress>
              <WeeklyPayment>
                <Currency></Currency>
                <Amount>Not asked</Amount>
              </WeeklyPayment>
              <RelationshipCarerToClaimant>father</RelationshipCarerToClaimant>
              <ChildDetails>
                <Name>Not asked</Name>
                <RelationToChild>grandFather</RelationToChild>
              </ChildDetails>
            </ChildCareExpenses>
              <CareExpensesCaree>yes</CareExpensesCaree> <CareExpenses>
              <CarerName>Carers UK Ltd</CarerName>
              <CarerAddress>
                <gds:Line>Not asked</gds:Line> <gds:Line>Not asked</gds:Line> <gds:Line>Not asked</gds:Line> <gds:PostCode></gds:PostCode>
              </CarerAddress>
              <ConfirmAddress>yes</ConfirmAddress>
              <WeeklyPayment>
                <Currency></Currency>
                <Amount>Not asked</Amount>
              </WeeklyPayment>
              <RelationshipCarerToClaimant>father</RelationshipCarerToClaimant>
              <RelationshipCarerToCaree>other</RelationshipCarerToCaree>
            </CareExpenses>
              <PaidForOccupationalPension>no</PaidForOccupationalPension> <PaidForPersonalPension>no</PaidForPersonalPension>
              <PaidForJobExpenses>yes</PaidForJobExpenses> <JobExpenses>
              <Expense>Petrol money for driving</Expense>
              <Reason>Not asked</Reason>
              <WeeklyPayment>
                <Currency></Currency>
                <Amount>Not asked</Amount>
              </WeeklyPayment>
            </JobExpenses>
            </JobDetails>
          </Employment>
          <PropertyRentedOut>
            <PayNationalInsuranceContributions/>
            <RentOutProperty>Not asked</RentOutProperty>
            <SubletHome>Not asked</SubletHome>
          </PropertyRentedOut>
          <HavePartner>no</HavePartner>

          <OtherBenefits>
            <ClaimantBenefits>
              <JobseekersAllowance>no</JobseekersAllowance>
              <IncomeSupport>no</IncomeSupport>
              <PensionCredit>no</PensionCredit>
              <StatePension>no</StatePension>
              <IncapacityBenefit>no</IncapacityBenefit>
              <SevereDisablementAllowance>no</SevereDisablementAllowance>
              <MaternityAllowance>no</MaternityAllowance>
              <UnemployabilitySupplement>no</UnemployabilitySupplement>
              <WindowsBenefit>no</WindowsBenefit>
              <WarWidowsPension>no</WarWidowsPension>
              <IndustrialDeathBenefit>no</IndustrialDeathBenefit>
              <GovernmentTrainingAllowance>no</GovernmentTrainingAllowance>
              <LoneParentChildBenefit>no</LoneParentChildBenefit>
              <OtherSocialSecurityBenefit>Not asked</OtherSocialSecurityBenefit>
              <NonSocialSecurityBenefit>Not asked</NonSocialSecurityBenefit>
              <NoBenefits>Not asked</NoBenefits>
            </ClaimantBenefits>
            <PartnerBenefits>
              <JobseekersAllowance>no</JobseekersAllowance>
              <IncomeSupport>no</IncomeSupport>
              <PensionCredit>no</PensionCredit>
              <StatePension>no</StatePension>
              <IncapacityBenefit>no</IncapacityBenefit>
              <SevereDisablementAllowance>no</SevereDisablementAllowance>
              <MaternityAllowance>no</MaternityAllowance>
              <UnemployabilitySupplement>no</UnemployabilitySupplement>
              <WindowsBenefit>no</WindowsBenefit>
              <WarWidowsPension>no</WarWidowsPension>
              <IndustrialDeathBenefit>no</IndustrialDeathBenefit>
              <GovernmentTrainingAllowance>no</GovernmentTrainingAllowance>
              <OtherSocialSecurityBenefit>Not asked</OtherSocialSecurityBenefit>
              <NonSocialSecurityBenefit>Not asked</NonSocialSecurityBenefit>
              <NoBenefits>Not asked</NoBenefits>
            </PartnerBenefits>
            <ExtraMoney>Not asked</ExtraMoney>
            <OtherMoneySSP>no</OtherMoneySSP>
            <OtherMoneySMP>no</OtherMoneySMP>
          </OtherBenefits>
          <Payment>
            <PaymentFrequency>fourWeekly</PaymentFrequency>
            <InitialAccountQuestion>bankBuildingAccount</InitialAccountQuestion>
            <Account>
              <DirectPayment>Not asked</DirectPayment>
              <AccountHolder>yourName</AccountHolder>
              <HolderName>Mr Test Casefour</HolderName>
              <SecondHolderName/>
              <AccountType>bank</AccountType>
              <OtherBenefitsToBePaidDirect/>
              <BuildingSocietyDetails>
                <BuildingSocietyQualifier/>
                <AccountNumber>12345678</AccountNumber>
                <RollNumber>1.23E+12</RollNumber>
                <SortCode>090123</SortCode>
                <Name>Lloyds</Name>
                <Branch></Branch>
                <Address>
                  <gds:Line></gds:Line> <gds:Line></gds:Line> <gds:Line></gds:Line> <gds:PostCode></gds:PostCode>
                </Address>
                <ConfirmAddress>yes</ConfirmAddress>
              </BuildingSocietyDetails>
            </Account>
          </Payment>
          <OtherInformation>What do you want me to tell you?</OtherInformation>
          <ThirdParty>no</ThirdParty>
          <Declaration>
            <TextLine>Do you agree to us getting information from any current or previous employer you have told us about as part of this claim? No</TextLine>
            <TextLine>If you answered No please tell us why</TextLine> <TextLine>I fell out with tem..,,34</TextLine>

            <TextLine>Do you agree to us getting information from any other person or organisation you have told us about as part of this claim? No</TextLine>
            <TextLine>If you answered No please tell us why</TextLine> <TextLine>I fell out with them 34!!</TextLine>

            <TextLine>This is my claim for Carer's Allowance.</TextLine>
            <TextLine>I understand that if I am paid Carer's Allowance it may affect the benefits paid to Test Middle CaseFour.</TextLine>
            <TextLine>If the person you are caring for receives certain benefits, the amount they receive may be affected by your claim for Carer's Allowance. Because of this we need both of you to understand the potential consequences of your claim to Carer's Allowance.</TextLine>
            <TextLine>If Test Middle CaseFour gets a Severe Disability Premium with their income-based Jobseeker's Allowance, Income Support, income-related Employment and Support Allowance, Housing Benefit, they may no longer get that premium if we pay Carer's Allowance to you.</TextLine>
            <TextLine>If Test Middle CaseFour's Pension Credit includes an extra amount for severe disability, they may no longer get that extra amount if we pay Carer's Allowance to you.</TextLine>
            <TextLine>This could also affect any reduction in Council Tax Test Middle CaseFour may be entitled to. To find out more about it, please contact the Local Authority.</TextLine>
            <TextLine>We will need to check Test Middle CaseFour entitlement to Disability Living Allowance, Personal Independence Payment, Attendance Allowance, Constant Attendance Allowance or Armed Forces Independence Payment when considering your claim.</TextLine>
            <TextLine>We may contact Test Middle CaseFour or their representative to establish whether 35 hours caring per week is taking place.</TextLine>
            <TextLine></TextLine>
            <TextLine>Please tick this box to declare that you have understood the notes and you have made / will make the person you are caring for / or their representative aware that there could be a change to their benefits. = yes</TextLine>

            <TextLine>I declare that I understand the Carer's Allowance Claim Notes and that the information provided on this claim form is correct and complete.</TextLine>
            <TextLine>I understand that I must report all changes in my circumstances or that of the person that I am caring for which may affect my entitlement promptly and by failing to do so I may be liable to prosecution or face a financial penalty.</TextLine>
            <TextLine>I will phone 08456084321 or write to Carer's Allowance Unit, Palatine House, Preston, Lancaster, PR1 1HB to report a change in my circumstances or that of the person that I am caring for.</TextLine>
            <TextLine>If I give false or incomplete information or fail to report changes in my circumstances or that of the person that I am caring for promptly, I understand that my Carer's Allowance may be stopped or reduced and any overpayment of Carer's Allowance may be recovered. In addition I may be prosecuted or face a financial penalty.</TextLine>
            <TextLine>We may wish to contact any current or previous employers, or other persons or organisations you have listed on this claim form to obtain information about your claim. You do not have to agree to this but if you do not, it may mean that we are unable to obtain enough information to satisfy ourselves that you meet the conditions of entitlement for your claim.</TextLine>
            <TextLine></TextLine>
            <TextLine>Please tick this box to confirm that you understand and make the declarations above. = yes</TextLine>
            <TextLine>Please tick this box if this claim form has been filled in by someone else, if so, please ensure that you understand the declarations above as another person cannot make the declarations on your behalf. = yes</TextLine>

            <TextLine>Do you live in Wales and would like to receive future communications in Welsh? Yes</TextLine>
          </Declaration>
          <EvidenceList>
            <TextLine>
              XML Generated at: 2013-10-16T12:24:19
            </TextLine> <TextLine>
            Send us the following documents below including your Name and National Insurance (NI) number.
          </TextLine> <TextLine/> <TextLine>
            Your Employment documents.
          </TextLine> <TextLine>
            Last payslip you got before your claim date: 05/01/2013
          </TextLine> <TextLine>
            Any payslips you have had since then.
          </TextLine> <TextLine>
            Any pension statements you may have.
          </TextLine> <TextLine/> <TextLine>
            Your Self-employed documents.
          </TextLine> <TextLine>
            Most recent finalised accounts you have for your business.
          </TextLine> <TextLine>
            Any pension statements you may have.
          </TextLine> <TextLine/> <TextLine>
            Send the above documents to:
          </TextLine> <TextLine>
            CA Freepost
          </TextLine> <TextLine>
            Palatine House
          </TextLine> <TextLine>
            Preston
          </TextLine> <TextLine>
            PR1 1HN
          </TextLine> <TextLine>
            The Carer's Allowance unit will contact you if they need any further information.
          </TextLine> <TextLine/> <TextLine>
            ======================About You======================
          </TextLine> <TextLine>
            Have you always lived in the UK? = Yes
          </TextLine> <TextLine>
            Mobile number = 0771 5419808
          </TextLine> <TextLine/> <TextLine>
            Do you get state Pension? = No
          </TextLine> <TextLine/> <TextLine>
            ================About Care You Provide================
          </TextLine> <TextLine>
            Do they live at the same address as you? = Yes
          </TextLine> <TextLine>
            Does this person get Armed Forces Independence Payment? = No
          </TextLine> <TextLine>
            Do you spend 35 hours or more each week caring for this person? = Yes
          </TextLine> <TextLine>
            Did you care for this person for 35 hours or more each week before your claim date ? = Yes
          </TextLine> <TextLine/> <TextLine>
            Where was the person you care for during the break? = Hospital
          </TextLine> <TextLine/> <TextLine>
            =====================Time abroad=====================
          </TextLine> <TextLine>
            Do you normally live in the UK, Republic of Ireland, Isle of Man or the Channel Islands? = Yes
          </TextLine> <TextLine>
            Have you had any more trips out of Great Britain for more than 52 weeks at a time, since 05/01/2013 (this is 156 weeks before your claim date)? = No
          </TextLine> <TextLine>
            Have you been out of Great Britain with the person you care for, for more than four weeks at a time, since 05/01/2013 (this is 3 years before your claim date)? = No
          </TextLine> <TextLine>
            ======================Employment======================
          </TextLine> <TextLine>
            Employer:Tesco's Bank
          </TextLine> <TextLine>
            About your wage,[[past=Did you]] [[present=Do you]] get the same amount each time? = No
          </TextLine> <TextLine>
            How much [[past=did you]] [[present=do you]] pay them - expenses related to childcare expenses? = 120.03
          </TextLine> <TextLine>
            How often [[past=did you]] [[present=do you]] - expenses related to childcare expenses? = Weekly
          </TextLine> <TextLine>
            How much [[past=did you]] [[present=do you]] pay them - expenses related to person you care for? = 150.89
          </TextLine> <TextLine>
            How often [[past=did you]] [[present=do you]] - expenses related to the person you care for? = Fortnightly
          </TextLine> <TextLine>
            ===================Self Employment===================
          </TextLine> <TextLine>
            Are the income, outgoings and profit in these accounts similar to your current level of trading? = No
          </TextLine> <TextLine>
            Please tell us why and when the change happened = Depends on the seasons, and productivity of the fruit.
          </TextLine> <TextLine>
            How much [[past=did you]] [[present=do you]] pay them - expenses related to childcare? = 234
          </TextLine> <TextLine>
            How often [[past=did you]] [[present=do you]] - expenses related to childcare expenses? = Fortnightly
          </TextLine> <TextLine>
            How much [[past=did you]] [[present=do you]] pay them - expenses related to person you care for? = 1235.01
          </TextLine> <TextLine>
            How often [[past=did you]] [[present=do you]] - expenses related to person you care for? = Fortnightly
          </TextLine> <TextLine>
            =====================Other Money=====================
          </TextLine> <TextLine>
            Have you
            &lt;
            or your partner/spouse
            &gt;
            claimed or received any other benefits since the date you want to claim? = No
          </TextLine> <TextLine>
            Have you received any payments for the person you care for or any other person since your claim date? = No
          </TextLine> <TextLine/>
            <TextLine/>
            <TextLine/>
            <TextLine/>
            <TextLine/>
            <TextLine/>
            <TextLine/>
            <TextLine/>
            <TextLine/>
            <TextLine/> <TextLine>
            Are you, your wife, husband, civil partner or parent you are dependent on, receiving any pensions or benefits from another EEA State or Switzerland? = No
          </TextLine> <TextLine>
            Are you, your wife, husband, civil partner or parent you are dependent on working in or paying insurance to another EEA State or Switzerland? = No
          </TextLine>
          </EvidenceList>
        </DWPCAClaim>
      </DWPCATransaction>
    </DWPBody>
  }
}
