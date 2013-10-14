package controllers

import play.api.mvc._


object Application extends Controller {
/*
  def submitClaim = Action {
    request =>
      request.body.asXml.map {
        xml =>
          val submissionXml = submissionservice.GGClaimSubmission(xml).createClaimSubmission
          Logger.info(s"Claim received transactionId : ${(submissionXml \\ "DWPCAClaim" \ "@id").text}")
          Async {
            val ggEndpoint: String = Configuration.root().getString("GGServerUrl")
            WS.url(ggEndpoint)
              .withHeaders(("Content-Type", "text/xml"))
              .post(submissionXml.buildString(stripComments = true)).map(
              response => {
                Logger.info(response.xml.buildString(stripComments = true))
                val correlationID = (response.xml \\ "CorrelationID").text
                response.status match {
                  case http.Status.OK => {
                    Logger.info(s"Acknowledgement CorrelationID : $correlationID")
                    val responseEndPoint = (response.xml \\ "ResponseEndPoint").text
                    Logger.info(s"ResponseEndPoint : $responseEndPoint")
                    if (correlationID.length > 0) {
                      val result = pollUntilSuccess(responseEndPoint, correlationID)
                      if ((result \\ "result").equals("response")) {
                        deleteRequest(correlationID, ggEndpoint)
                      }
                      Ok(result.buildString(stripComments = true))
                    } else {
                      Logger.error("No correlation Id from gateway")
                      Ok(resultXml("error", "No correlation Id from gateway", "", responseEndPoint))
                    }
                  }
                  case _ => {
                    Logger.error("Bad response from gateway")
                    Ok(resultXml("error", correlationID, "", ""))
                  }
                }
              }
            ).recover {
              case e: java.net.ConnectException => {
                Logger.error(e.getStackTraceString)
                Ok(resultXml("error", e.getMessage, "", ""))
              }
              case e: java.lang.Exception => {
                Logger.error(e.getStackTraceString)
                InternalServerError(resultXml("error", e.getMessage, "", ""))
              }
            }
          }
      }.getOrElse {
        Logger.error("Expecting Xml data")
        BadRequest("Expecting Xml data")
      }
  }

  def retryClaim = Action {
    request =>
      request.body.asXml.map {
        xml =>
          val correlationID = (xml \\ "correlationID").text
          Logger.info(s"retryClaim : correlationID : $correlationID")
          val pollEndpoint = (xml \\ "pollEndpoint").text
          Logger.info(s"retryClaim : pollEndpoint : $pollEndpoint")
          val result = pollUntilSuccess(pollEndpoint, correlationID)
          if ((result \\ "result").equals("response")) {
            deleteRequest(correlationID, pollEndpoint)
          }
          Ok(result.buildString(stripComments = true))
      }.getOrElse {
        Logger.error("Expecting Xml data")
        BadRequest("Expecting Xml data")
      }
  }

  def pollUntilSuccess(responseEndPoint: String, correlationID: String): Elem = {
    Logger.debug("firstPoll")
    val firstPoll = poll(responseEndPoint, correlationID)
    if ((firstPoll \\ "result").text.equals("acknowledgement")) {
      Logger.debug("secondPoll")
      val secondPoll = poll(responseEndPoint, correlationID)
      if ((secondPoll \\ "result").text.equals("acknowledgement")) {
        Logger.debug("thirdPoll")
        poll(responseEndPoint, correlationID)
      } else {
        secondPoll
      }
    } else {
      firstPoll
    }
  }

  def poll(responseEndPoint: String, correlationID: String): Elem = {
    Logger.debug("Sleeping")
    Thread.sleep(3000)
    Logger.debug("Wake-up")
    val futureResult = WS.url(responseEndPoint)
      .withHeaders(("Content-Type", "text/xml"))
      .post(PollSubmission.buildSubmission(correlationID).buildString(stripComments = true)).map {
      resp => {
        Logger.info(resp.xml.buildString(stripComments = true))
        resp.status match {
          case http.Status.OK => resultXml((resp.xml \\ "Qualifier").text, correlationID, (resp.xml \\ "Error" \\ "Number").text, responseEndPoint)
          case _ => {
            Logger.error(resp.body)
            resultXml((resp.xml \\ "Qualifier").text, correlationID, "error", responseEndPoint)
          }
        }
      }
    }
    Await.result(futureResult, Duration("10 seconds"))
  }

  def resultXml(result: String, correlationID: String, errorCode: String, pollEndpoint: String) = {
    <response>
      <result>{result}</result>
      <correlationID>{correlationID}</correlationID>
      <pollEndpoint>{pollEndpoint}</pollEndpoint>
      <errorCode>{errorCode}</errorCode>
    </response>
  }

  def buildDeleteXml(correlationId: String): Elem = {
    <GovTalkMessage xmlns="http://www.govtalk.gov.uk/CM/envelope">
      <EnvelopeVersion>2.0</EnvelopeVersion>
      <Header>
        <MessageDetails>
          <Class>DWP-CA-CLAIM-0T0</Class>
          <Qualifier>request</Qualifier>
          <Function>delete</Function>
          <CorrelationID>
            {correlationId}
          </CorrelationID>
          <Transformation>XML</Transformation>
          <GatewayTimestamp/>
        </MessageDetails>
        <SenderDetails/>
      </Header>
      <GovTalkDetails>
        <Keys/>
      </GovTalkDetails>
      <Body>
      </Body>
    </GovTalkMessage>
  }

  def deleteRequest(correlationID: String, ggEndpoint: String) {
    val deleteXml = buildDeleteXml(correlationID)
    WS.url(ggEndpoint)
      .withHeaders(("Content-Type", "text/xml"))
      .post(deleteXml.buildString(stripComments = true)).map(
      response => {
        Logger.info(s"Delete request for $correlationID")
      }
    )
  }

*/
}