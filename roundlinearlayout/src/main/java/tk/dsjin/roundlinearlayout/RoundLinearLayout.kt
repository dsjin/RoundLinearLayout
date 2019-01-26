/*
 * Copyright 2019 Thatchakon Jom-ud
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tk.dsjin.roundlinearlayout

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.TypedValue
import android.widget.LinearLayout

class RoundLinearLayout: LinearLayout {
    private var radius : Int
    private var path : Path
    constructor(context : Context): super(context)
    constructor(context: Context, attrs : AttributeSet):super(context, attrs){
        val a = context.obtainStyledAttributes(attrs, R.styleable.RoundLinearLayout)
        radius = convertRadius(a.getInt(R.styleable.RoundLinearLayout_radius, 20))
        a.recycle()
    }
    constructor(context : Context, attrs : AttributeSet, defStyleAttr : Int):super(context, attrs, defStyleAttr)
    init {
        path = Path()
        radius = 20
    }
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        setNewPath(w, h)
    }

    override fun draw(canvas : Canvas) {
        val save = canvas.save()
        canvas.clipPath(path)
        super.draw(canvas)
        canvas.restoreToCount(save)
    }

    fun setRadius(radius : Int){
        this.radius = convertRadius(radius)
        setNewPath(super.getWidth(), super.getHeight())
        invalidate()
    }

    private fun convertRadius(radius : Int) : Int{
        val displayMetrics : DisplayMetrics = context.resources.displayMetrics
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, radius.toFloat(), displayMetrics).toInt()
    }

    private fun setNewPath(w : Int , h : Int){
        path.reset()
        val rect = RectF()
        rect.set(0f, 0f, w.toFloat(), h.toFloat())
        path.addRoundRect(rect, radius.toFloat(), radius.toFloat(), Path.Direction.CW)
        path.close()
    }
}