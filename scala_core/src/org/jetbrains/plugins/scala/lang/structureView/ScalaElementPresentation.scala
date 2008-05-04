package org.jetbrains.plugins.scala.lang.structureView

import org.jetbrains.plugins.scala.lang.psi._
import org.jetbrains.plugins.scala.lang.psi.api.toplevel.typedef._
import org.jetbrains.plugins.scala.lang.psi.api.statements._

/**
* @author Alexander Podkhalyuzin
* Date: 04.05.2008
*/

object ScalaElementPresentation {
  def getFilePresentableText(file: ScalaFile): String = {
    return file.getName()
  }
  def getTypeDefinitionPresentableText(typeDefinition: ScTypeDefinition): String = {
    return typeDefinition.nameNode.getText();
  }
  def getMethodPresentableText(function: ScFunction): String = {
    val presentableText: StringBuffer = new StringBuffer("")
    presentableText.append(function.getNameNode.getText)
    return presentableText.toString()
  }
}