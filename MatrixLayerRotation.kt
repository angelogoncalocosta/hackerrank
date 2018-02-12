var mat: ArrayList<IntArray> = arrayListOf()

fun main(args: Array<String>) {
    val sizes = readLine()!!.split(" ").map { it.toInt() }
    val h = sizes[0]
    val w = sizes[1]
    for (i in 0 until h) {
        mat.add(readLine()!!.split(" ").map { it.toInt() }.toIntArray())
    }
    transform(w, h, sizes[2])
}

fun transform(w: Int, h: Int, rot: Int) {
    val layers = Math.min(h, w) / 2
    for (layer in 0 until layers) {
        // rot % (2 * (h + w - 2 - 4 * layer))
        // h + w - 2 - 4 * layer -> get half the size of the matrix in that layer
        // 2 * (h + w - 2 - 4 * layer) -> correct the size
        // rot % (2 * (h + w - 2 - 4 * layer)) -> the rotation only has to be performed "x" amount of times, the rest
        // is repetition. Thus the "mod" of the inputted rotation with the "x" gives the minimum amount of times the
        // layer has to rotate.
        // Example: in a 5x4 matrix the outtermost layer full rotation takes maximum 14 steps, thus if the user ask
        // for 17 rotations it takes 14 + 3, thus only 3 rotations are needed; and if it asks for 46 rotations it takes
        // (14 * 3) + 4, thus only 4 rotations are needed. 46 mod 14 = 4 and 17 mod 14 = 3
        for (i in 0 until rot % (2 * (h + w - 2 - 4 * layer))) {
            rotateMatrix(w, h, layer)
        }
    }
    mat.forEach { println(it.joinToString(" ")) }
}

fun rotateMatrix(w: Int, h: Int, layer: Int) {
    val mat2: ArrayList<Int> = arrayListOf()
    // Top
    (layer..(w - 1 - layer)).mapTo(mat2) { mat[layer][it] }
    // Right
    (layer..(h - 1 - layer)).mapTo(mat2) { mat[it][w - 1 - layer] }
    // Bottom
    ((w - 1 - layer) downTo layer).mapTo(mat2) { mat[h - 1 - layer][it] }
    // Left
    ((h - 1 - layer) downTo layer).mapTo(mat2) { mat[it][layer] }

    // "Drop" the first element to start in the second
    var startat = 1
    // Top
    for (i in layer..w - 1 - layer) {
        mat[layer][i] = mat2[startat++]
    }
    // Right
    for (i in layer..h - 1 - layer) {
        mat[i][w - 1 - layer] = mat2[startat++]
    }
    // Bottom
    for (i in (w - 1 - layer) downTo layer) {
        mat[h - 1 - layer][i] = mat2[startat++]
    }
    // Left (minus 1 that was dropped)
    for (i in (h - 1 - layer) downTo layer) {
        if (startat < mat2.size) {
            mat[i][layer] = mat2[startat++]
        }
    }
}
