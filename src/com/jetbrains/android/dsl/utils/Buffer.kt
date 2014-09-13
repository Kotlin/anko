package com.jetbrains.android.dsl.utils

public class Buffer(private val indentSymbol: String, val init: Buffer.() -> Unit) {

  private val builder = StringBuilder();
  private var mainIndent = 0;
  private var tempIndent = 0;

  { init() }

  public fun line(s: String): Buffer {
    if (mainIndent >0 && s.startsWith('}'))
      mainIndent = mainIndent - 1

    if (s.isNotEmpty())
      builder.append(indentSymbol.repeat(mainIndent+tempIndent)).append(s.trim()).append('\n')
    else builder.append('\n')

    if (tempIndent>0)
      tempIndent = tempIndent - 1
    if (s.endsWith('{'))
      mainIndent = mainIndent + 1
    else if (s.endsWith('='))
      tempIndent = tempIndent + 1
    return this
  }

  public fun nl(): Buffer = line("")

  public val indent: Buffer
    get() {
      tempIndent = tempIndent + 1
      return this
    }

  public fun lines(lines: List<String>): Buffer {
    for (line in lines)
      line(line)
    return this
  }

  public val size: Int
    get() = builder.size

  public val isEmpty: Boolean
    get() = builder.size == 0

  override fun toString(): String {
    return builder.toString()
  }
}