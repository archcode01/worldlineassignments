/**
  * Copyright (c) Metro Group
  */
package assignment2.models

case class BillOfMaterials(materials: Seq[Widget]) {
  def print = if(materials.forall(_.isValid)) printValid else printInvalid

  def printInvalid = "+++++Abort+++++"

  def printValid: String = {
    val header =
      s"----------------------------------------------------------------\n" +
        s"Bill of Materials\n" +
        s"----------------------------------------------------------------\n"

    val footer = s"\n----------------------------------------------------------------\n"
    val body = materials.map(_.print).mkString("\n")

    header + body + footer

  }
}
