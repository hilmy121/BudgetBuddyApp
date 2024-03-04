package com.credeative.budgetbuddy.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.credeative.budgetbuddy.data.datamodel.Needs
import com.credeative.budgetbuddy.ui.theme.PrimaryNeeds
import com.credeative.budgetbuddy.ui.theme.SecondaryNeeds
import com.credeative.budgetbuddy.ui.theme.TertiaryNeeds
import kotlin.math.PI
import kotlin.math.atan2

@Composable
fun PieChart(
    modifier: Modifier = Modifier,
    radius:Float = 500f,
    input:List<Needs>
){

    var circleCenter by remember {
        mutableStateOf(Offset.Zero)
    }

    var inputList by remember {
        mutableStateOf(input)
    }
    
//    var isCenterTapped by remember {
//        mutableStateOf(false)
//    }

    val animateFloat = remember {
        Animatable(0f)
    }

//    LaunchedEffect(key1 = animateFloat, block = {
//        animateFloat.animateTo(
//            targetValue = 1f,
//            animationSpec = tween(durationMillis = 3000, easing = LinearEasing)
//        )
//    })

    Box(modifier = modifier, contentAlignment = Alignment.Center){
        Canvas(modifier = Modifier
            .fillMaxSize()
            .pointerInput(key1 = true, block = {
                detectTapGestures(onTap = {
                    offset ->  val tapAngleInDegrees = (-atan2(
                    x = circleCenter.y - offset.y,
                    y = circleCenter.x - offset.x
                ) * (180f / PI).toFloat() - 90f).mod(360f)
                    val anglePerValue = 360f/input.sumOf {
                        it.value
                    }
                    var currentAngle = 0f
                    inputList.forEach { need->
                        currentAngle += need.value * anglePerValue

                        if (tapAngleInDegrees<currentAngle){
                            val description = need.name
                            inputList = inputList.map {
                                if (description.equals(it.name)){
                                    it.copy(tapped = !it.tapped)
                                }else{
                                    it.copy(tapped = false)
                                }
                            }
                            return@detectTapGestures
                        }
                    }

                }


                )
            }), onDraw = {
            val width = size.width
            val height = size.height
            circleCenter = Offset(width/2,height/2)
            val totalValue = input.sumOf {
                it.value
            }
            val anglePerValue = 360f/totalValue

            var currentStartAngle = 0f
            inputList.forEach { need ->
                val angleToDraw = need.value * anglePerValue
                val scale = if (need.tapped) 1.1f else 1.0f
                scale(scale){
                    drawArc(
                        color = need.color,
                        startAngle = currentStartAngle,
                        sweepAngle = angleToDraw,
                        useCenter = true,
                        size = Size(width = radius*2f,height=radius*2f),
                        topLeft = Offset(x = (width-radius*2f/2), y = (height-radius*2f)/2) )
                    currentStartAngle += angleToDraw
                }





            }

        })
    }
}



@Composable
@Preview
fun PieChartPreview(){
    Box (modifier = Modifier.fillMaxSize()){
        PieChart(modifier = Modifier
            .size(10.dp)
            .align(Alignment.Center),input = listOf(
            Needs(color = PrimaryNeeds,"Primary",15, false),
            Needs(color = SecondaryNeeds,"Secondary",15,false),
            Needs(color = TertiaryNeeds,"Tertiary",15,false)
        ))
    }

}