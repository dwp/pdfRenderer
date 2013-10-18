package generators

import net.sf.jasperreports.engine._
import net.sf.jasperreports.crosstabs.JRCrosstab


abstract class RecursiveVisitor extends JRVisitor {
  def visitBreak(breakElement: JRBreak) = {}

  def visitChart(chart: JRChart) = {}

  def visitCrosstab(crosstab: JRCrosstab) = {}

  def visitElementGroup(elementGroup: JRElementGroup) = {}

  def visitEllipse(ellipse: JREllipse) = {}

  def visitFrame(frame: JRFrame) = {}

  def visitImage(image: JRImage) = {}

  def visitLine(line: JRLine) = {}

  def visitRectangle(rectangle: JRRectangle) = {}

  def visitStaticText(staticText: JRStaticText) = {}

  def visitSubreport(subreport: JRSubreport): Unit = {}

  def visitTextField(textField: JRTextField) = {}

  def visitComponentElement(componentElement: JRComponentElement) = {}

  def visitGenericElement(element: JRGenericElement) = {}
}
