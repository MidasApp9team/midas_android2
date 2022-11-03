package com.example.midasandroid2.main.compose

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.midasandroid2.R
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@DelicateCoroutinesApi
@Composable
fun MainComposeHelper(
    inTime: String? = null,
    outTime: String? = null,
    homeWorking: Boolean = true
){
    var graphWidth by remember { mutableStateOf(1440) }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 1.dp)
        .background(
            color = BaseColor.White,
            shape = RoundedCornerShape(40.dp)
        )
        .btnClickable {
            GlobalScope.launch {
                graphWidth = 0
                delay(2000)
                graphWidth = 1440
            }
        }
    ){
        Column(
            modifier = Modifier
                .padding(horizontal = 22.dp)
        ) {
            Spacer(modifier = Modifier.height(13.dp))
            
            TopRow()

            Spacer(modifier = Modifier.height(23.dp))

            Commute(inTime = inTime, outTime = outTime, homeWorking = homeWorking)
            
            Spacer(modifier = Modifier.height(16.dp))

            Row() {
                Body2(text = stringResource(id = R.string.total_work_time))
                
                Body2(
                    text = "4시간 30분",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.End)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row() {
                Body3(text = stringResource(id = R.string.week_work_time))

                Body3(
                    text = "18시간 30분",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.End)
                )
            }
            Row() {
                Body3(text = stringResource(id = R.string.week_work_time_left))

                Body3(
                    text = "18시간 30분",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.End)
                )
            }
            
            Spacer(modifier = Modifier.height(30.dp))

            Graph(graphStart = 0, graphWidth = graphWidth, graphColor = BaseColor.Red)
        }
    }
}

@Stable
private val TopRowHeight: Dp = 36.dp

@Composable
fun TopRow() {
    Row(modifier = Modifier
        .height(TopRowHeight)
    ) {
        Body1(text = stringResource(id = R.string.commute_now))

        Spacer(modifier = Modifier.width(5.dp))

        Body2(
            text = stringResource(id = R.string.today),
            color = BaseColor.Black40,
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentHeight(Alignment.Bottom)
        )
    }
}

@Stable
private val CommuteHeight: Dp = 42.dp

@Composable
fun Commute(
    inTime: String?,
    outTime: String?,
    homeWorking: Boolean
){
    val inTime = if(inTime.isNullOrEmpty()) "xx:xx" else inTime
    val outTime = if(outTime.isNullOrEmpty()) "xx:xx" else outTime

    Row(
        modifier = Modifier
            .height(CommuteHeight)
    ) {
        Column() {
            Body2(
                text = stringResource(id = R.string.in_time)
                    +"   "
                    +inTime,
                color = BaseColor.LightGreen
            )
            
            Body2(
                text = stringResource(id = R.string.out_time)
                        +"   "
                        +outTime,
                color = BaseColor.Red,
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentHeight(Alignment.Bottom)
            )
        }

        if(homeWorking){
            Body1(
                text = stringResource(id = R.string.home_working),
                color = BaseColor.LightGreen,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight(Alignment.CenterVertically)
                    .wrapContentWidth(Alignment.End)
            )
        }
    }
}

@Stable
private val GraphWidth: Dp = 360.dp

@Stable
private val GraphHeight: Dp = 30.dp

@Stable
private val GraphCornerShape: Dp = 4.dp

@Stable
private val GraphAnimationTween: Int = 2000

@Composable
fun Graph(
    graphStart: Int,
    graphWidth: Int,
    graphColor: Color
) {

    val animationProgress: Float by animateFloatAsState(
        targetValue = (graphWidth / 4).toFloat(),
        tween(GraphAnimationTween)
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .width(GraphWidth)
            .height(GraphHeight)
            .background(
                color = BaseColor.Gray,
                shape = RoundedCornerShape(GraphCornerShape)
            )
    ){
        Box(
            modifier = Modifier
                .padding(start = graphStart.dp)
                .width(animationProgress.toInt().dp)
                .fillMaxHeight()
                .background(
                    color = graphColor
                )
        )
    }
}