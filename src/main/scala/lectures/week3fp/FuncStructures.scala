package lectures.week3fp

val someVal = Some(2)
val result5 = someVal.flatMap(v => Option(v * 2))
val result6 = someVal.map(_*2)
