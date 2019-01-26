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
import android.widget.LinearLayout

class RoundLinearLayout: LinearLayout {
    private var radian : Int
    private var path : Path
    constructor(context : Context): super(context)
    constructor(context: Context, attrs : AttributeSet):super(context, attrs){
        val a = context.obtainStyledAttributes(attrs, R.styleable.RoundLinearLayout)
        radian = a.getInt(R.styleable.RoundLinearLayout_radian, 20)
        a.recycle()
    }
    constructor(context : Context, attrs : AttributeSet, defStyleAttr : Int):super(context, attrs, defStyleAttr)
    init {
        path = Path()
        radian = 20
    }
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        path.reset()
        val rect = RectF()
        rect.set(0f, 0f, w.toFloat(), h.toFloat())
        path.addRoundRect(rect, radian.toFloat(), radian.toFloat(), Path.Direction.CW)
        path.close()
    }

    override fun draw(canvas: Canvas) {
        val save = canvas.save()
        canvas.clipPath(path)
        super.draw(canvas)
        canvas.restoreToCount(save)
    }

    fun setRadius(radian : Int){
        this.radian = radian
        invalidate()
    }
}