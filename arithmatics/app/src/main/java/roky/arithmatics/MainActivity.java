package roky.arithmatics;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import android.content.*;
import android.view.View.*;
import android.util.*;
import android.media.*;

public class MainActivity extends Activity implements View.OnClickListener
{
	private int totalPoint = 0;
	private int rightCount = 0;
	private int level = 1;

	Button startButton;
	TextView arg1; 
	TextView arg2;
	TextView answer;
	Toast toastTrue;
	Toast toastEmpty;
	Button checkButton;
	Button showResultButton;
	TextView rightText;
	TextView pointText;
	TextView levelText;
	Button resetButton;
	// numeric button
	Button one;
	Button two;
	Button three;
	Button four;
	Button five;
	Button six;
	Button seven;
	Button eight;
	Button nine;
	Button zero;
	Button enter;
	Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		startButton = (Button) findViewById(R.id.start);
		arg1 = (TextView) findViewById(R.id.arg1);
		arg2 = (TextView) findViewById(R.id.arg2);
		answer = (TextView) findViewById(R.id.answer);
	/*	answer.setOnKeyListener(new OnKeyListener() {
				public boolean onKey(View v, int keyCode, KeyEvent event)
				{
					// If the event is a key-down event on the "enter" button
					if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
						(keyCode == KeyEvent.KEYCODE_ENTER))
					{
						// Perform action on key press
						checkAnswer();
						return true;
					}
					return false;
				}
			});*/
		toastTrue = Toast.makeText(this, R.string.result_true, Toast.LENGTH_LONG);
		toastEmpty = Toast.makeText(this, R.string.empty, Toast.LENGTH_LONG);
		checkButton = (Button) findViewById(R.id.check);
		rightText = (TextView) findViewById(R.id.right_count);
		pointText = (TextView) findViewById(R.id.show_point);
		levelText = (TextView) findViewById(R.id.show_level);
		answer.setVisibility(View.GONE);
		
	    one = (Button) findViewById(R.id.one);
		two = (Button) findViewById(R.id.two);
		three = (Button) findViewById(R.id.three);
		four = (Button) findViewById(R.id.four);
		five = (Button) findViewById(R.id.five);
		six = (Button) findViewById(R.id.six);
		seven = (Button) findViewById(R.id.seven);
		eight = (Button) findViewById(R.id.eight);
		nine = (Button) findViewById(R.id.nine);
		zero = (Button) findViewById(R.id.zero);
		enter = (Button) findViewById(R.id.enter);
		clear = (Button) findViewById(R.id.clear);
		
		one.setOnClickListener(this);
		two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
		enter.setOnClickListener(this);
		clear.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
        int id=v.getId();
		if(id==R.id.one){
			answer.setText(answer.getText() + one.getText().toString());
		}
		else if(id==R.id.two){
			answer.setText(answer.getText() + two.getText().toString());
		}
		else if(id==R.id.three){
			answer.setText(answer.getText() + three.getText().toString());
		}else if(id==R.id.four){
			answer.setText(answer.getText() + four.getText().toString());
		}else if(id==R.id.five){
			answer.setText(answer.getText() + five.getText().toString());
		}else if(id==R.id.six){
			answer.setText(answer.getText() + six.getText().toString());
		}else if(id==R.id.seven){
			answer.setText(answer.getText() + seven.getText().toString());
		}else if(id==R.id.eight){
			answer.setText(answer.getText() + eight.getText().toString());
		}else if(id==R.id.nine){
			answer.setText(answer.getText() + nine.getText().toString());
		}else if(id==R.id.zero){
			answer.setText(answer.getText() + zero.getText().toString());
		}else if(id==R.id.enter){
			checkAnswer();
		}else if(id==R.id.clear){
			answer.setText("");
		}
	}


	public void startArithmatics(View view)
	{
		startButton.setEnabled(false);
		showAgrs(level);
		checkButton.setEnabled(true);
		answer.setVisibility(View.VISIBLE);
		answer.setFocusable(true);
	}

	private void showAgrs(int argLevel)
	{
		int randomBase = (argLevel - 1) * 5;
		Random r = new Random();
		int i1 = r.nextInt(4) + randomBase + 1;
		arg1.setText("" + i1);
		int i2 = r.nextInt(4) + randomBase + 1;
		arg2.setText("" + i2);
		answer.setText("");
	}

	public void checkAnswer(View view)
	{
		checkAnswer();
	}
	public void checkAnswer()
	{
		int a1 = Integer.parseInt(arg1.getText().toString());
		int a2 = Integer.parseInt(arg2.getText().toString());
		int ans = 0;
		String ansText = answer.getText().toString().trim();
		
		if (ansText.length() == 0)
		{
			toastEmpty.show();
			showAgrs(level);
		}
		ans = Integer.parseInt(ansText);

		if (a1 + a2 == ans)
		{
			rightCount++;
			totalPoint += level;
			toastTrue.show();
			if (rightCount % 5 == 0)
			{
				level++;
			}
			rightText.setText(getString(R.string.right_count) + rightCount);
			pointText.setText(getString(R.string.point_count) + totalPoint); 
			levelText.setText(getString(R.string.level_count) + level);
			showAgrs(level);
		}
		else
		{
			showResult();
		}

	}

	public void showResult()
	{
		String textResult = "";
		textResult += getString(R.string.right_count);
		textResult += " " + rightCount + "\n";
		textResult += getString(R.string.point_count);
		textResult += " " + totalPoint + "\n";
		textResult += getString(R.string.level_count);
		textResult += " " + level + "\n";
		if (level <= 2)
		{
			textResult += "\n" + getString(R.string.ni);
		}
		else if (level <= 4)
		{
			textResult += "\n" + getString(R.string.good);
		}
		else if (level <= 6)
		{
			textResult += "\n" + getString(R.string.great);
		}
		else
		{
			textResult += "\n" + getString(R.string.perfect);			
		}
		showAlert(textResult);

		//resetButton.setEnabled(true);
	}

	private void showAlert(String msg)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this); // 여기서 this는 Activity의 this

		// 여기서 부터는 알림창의 속성 설정
		builder.setTitle(getString(R.string.show_result)) // 제목 설정
			.setMessage(msg) // 메세지 설정
			.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener(){       
				// 확인 버튼 클릭시 설정
				public void onClick(DialogInterface dialog, int whichButton)
				{
					dialog.cancel();
					reset();
				}
			});

		AlertDialog dialog = builder.create();    // 알림창 객체 생성
		dialog.show();    // 알림창 띄우기
	}

	public void reset()
	{
		totalPoint = 0;
		rightCount = 0;
		level = 1;

		startButton.setEnabled(true);
		arg1.setText(""); 
		arg2.setText(""); 
		answer.setText("");
		checkButton.setEnabled(false);
		rightText.setText("");
		pointText.setText("");
		levelText.setText("");
		//resetButton.setEnabled(false);
	}
	
	public void playSound(View v){
		final ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
		tg.startTone(ToneGenerator.TONE_PROP_BEEP);
	}
}
