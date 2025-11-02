package com.example.physioquest

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.google.mlkit.vision.pose.Pose
import com.google.mlkit.vision.pose.PoseLandmark

class PoseOverlayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : View(context, attrs) {

    private var currentPose: Pose? = null
    private val paint = Paint().apply {
        color = Color.GREEN
        style = Paint.Style.FILL
        strokeWidth = 8f
    }

    fun setPose(pose: Pose) {
        currentPose = pose
        invalidate() // วาดใหม่
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        currentPose?.allPoseLandmarks?.forEach { landmark ->
            canvas.drawCircle(landmark.position.x, landmark.position.y, 8f, paint)
        }
    }
}
