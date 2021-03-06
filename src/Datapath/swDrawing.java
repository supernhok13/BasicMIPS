/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datapath;


import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class swDrawing extends ModelDrawing {
	private int [][]arrayLine = {
			{90,350,140,350},{115,350,115,50},{115,50,142,50},{100,130,142,130},
			{230,395,250,395},{250,395,250,350},{250,350,410,350},{250,380,410,380},
			{300,380,300,430},{300,430,350,430},{250,350,250,250},{250,250,370,250},
			{250,395,250,470},{250,470,350,470},{395,220,395,210},{395,210,240,210},
			{240,210,240,510},{240,510,365,510},{365,510,365,495},{380,445,410,445},
			{250,470,250,560},{250,560,450,560},{400,560,400,620},{400,620,540,620},
			{540,620,540,570},{540,570,620,570},{550,365,700,365},{550,420,650,420},
			{510,560,600,560},{600,560,600,460},{600,460,650,460},{420,300,665,300},
			{665,300,665,400},{680,440,700,440},{600,460,600,185},{600,185,630,185},
			{660,185,685,185},{205,100,600,100},{600,100,600,70},{600,70,790,70},
			{600,100,685,100},{750,140,795,140},{420,265,560,265},{560,265,560,630},
			{560,630,650,630},{650,630,650,610},{680,570,750,570},{750,570,750,440},
			{765,400,775,400},{775,400,775,200},{775,200,780,200},{411,226,780,226},
			{820,215,825,215},{825,215,825,150},{840,100,890,100},{890,100,890,20},
			{890,20,20,20},{20,20,20,350},{20,350,50,350},{765,410,820,410},
			{550,420,570,420},{570,420,570,500},{570,500,820,500},{418,282,860,282},
			{860,282,860,400},{417,240,870,240},{870,240,870,400},{775,410,775,550},
			{775,550,935,550},{935,550,935,465},{935,465,950,465},{910,410,950,410},
			{420,250,965,250},{965,250,965,400},{410,305,450,305},{450,305,450,330},
			{980,440,1010,440},{1010,440,1010,650},{1010,650,390,650},{390,650,390,470},
			{390,470,410,470}
	};
	public swDrawing()
	{
            arrayLength = arrayLine.length;
		timer = new Timer(delay,new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//
				if(isBack ||isForward)
                                    repaint();
                                else
                                {
                                    repaint();
                                    Calculate(arrayLine[lineNumber][0],arrayLine[lineNumber][1],arrayLine[lineNumber][2],arrayLine[lineNumber][3]);
                                }
			}
		});
		timer.setInitialDelay(250);
		timer.start();
	}
        
        private void BackorForward(Graphics2D gr2d)
        {
            DrawingLine(gr2d);
            xdyn = arrayLine[lineNumber][0];
            ydyn = arrayLine[lineNumber][1];
        }
        
	private void DrawingAnimatedLine(Graphics2D gr2d, int X1, int Y1)
	{
		gr2d.setPaint(getCritColor());
		gr2d.setRenderingHints(renderhints);
        gr2d.setStroke (
                new BasicStroke ( thickness+1f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND ) );
        if(xdyn != 0 && ydyn!= 0)
        {
        	if((lineNumber>13&&lineNumber<19)||(lineNumber>30&&lineNumber<33)||(lineNumber>41&&lineNumber<54)||(lineNumber>62&&lineNumber<67)||(lineNumber>71&&lineNumber<76))
        	{
        		gr2d.create();
        		gr2d.setPaint(getInsColor());
        		gr2d.drawLine(X1, Y1,xdyn,ydyn);
        	}
        	else if((lineNumber>7&&lineNumber<10) ||lineNumber ==13||lineNumber==19 ||(lineNumber>21&&lineNumber<26)||lineNumber ==27||(lineNumber>33&&lineNumber<37)||(lineNumber>39&&lineNumber<42)||(lineNumber>66&&lineNumber<72)||lineNumber>75)
			{
				gr2d.create();
				gr2d.setPaint(getUniColor());
				gr2d.drawLine(X1, Y1,xdyn,ydyn);
			}
        	else
        		gr2d.drawLine(X1, Y1,xdyn,ydyn);
        	DrawingLine(gr2d);
        }
        gr2d.dispose();
	}
	
	private void DrawingLine(Graphics2D gr2d)
	{	
		gr2d.setPaint(getCritColor());
		gr2d.setRenderingHints(renderhints);
        gr2d.setStroke (
                new BasicStroke ( thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND ) );
        if(lineNumber >= 1)
		{
			for(int i=0;i < lineNumber ;i++)
			{
				if(i==2)
					gr2d.drawString("4", 90, 132);
				if((i>13&&i<19)||(i>30&&i<33)||(i>41&&i<54)||(i>62&&i<67)||(i>71&&i<76))
				{
					gr2d.create();
					gr2d.setPaint(getInsColor());
                                    switch (i) {
                                        case 14:
                                            gr2d.drawString("RegDst", 350, 205);
                                            break;
                                        case 31:
                                            gr2d.drawString("ALUSrc", 430, 295);
                                            break;
                                        case 42:
                                            gr2d.drawString("ALUOp", 430, 262);
                                            break;
                                        case 63:
                                            gr2d.drawString("MemWrite", 430, 278);
                                            break;
                                        case 65:
                                            gr2d.drawString("MemRead", 430, 238);
                                            break;
                                        case 72:
                                            gr2d.drawString("MemtoReg", 930, 248);
                                            break;
                                        case 73:
                                            gr2d.drawString("RegWrite", 455, 313);
                                            break;
                                        case 50:
                                            gr2d.fillRect(780,195,20,40);
                                            gr2d.fillOval(780,195,40,40);
                                            gr2d.drawString("Branch", 435, 223);
                                            break;
                                        default:
                                            break;
                                    }
				}
				else if((i>7&&i<10) ||i==13||i==19||(i>21&&i<26)||i==27||(i>33&&i<37)||(i>39&&i<42)||(i>66&&i<72)||i>75)
				{
					gr2d.create();
					gr2d.setPaint(getUniColor());
                                        if(i==13)
                                        gr2d.drawString(RD, 280, 465);
                                        if(i==23)
                                        gr2d.drawString(funct, 420, 635);
				}
				else
                                {
                                    gr2d.setPaint(getCritColor());
                                    if(i==6)
                                        gr2d.drawString(RS, 280, 345);
                                    if(i==7)
                                        gr2d.drawString(RT, 280, 375);
                                    if(i==11)
                                       gr2d.drawString(opcode, 280, 245);
                                    if(i==21)
                                        gr2d.drawString(RD+shamt+funct,270,555);
                                }
				gr2d.drawLine(arrayLine[i][0], arrayLine[i][1], arrayLine[i][2], arrayLine[i][3]);
			}
		}
         if(lineNumber == arrayLine.length-1 && isForward)
                {
                        gr2d.setPaint(getUniColor());
                        gr2d.drawLine(arrayLine[lineNumber][0], arrayLine[lineNumber][1], arrayLine[lineNumber][2], arrayLine[lineNumber][3]);
                }
        gr2d.dispose();
	}
	
	public void paintComponent(Graphics gr)
	{
		super.paintComponent(gr);
		DrawingBlocks((Graphics2D) gr);
		DrawingIns((Graphics2D)gr);
                if(lineNumber == arrayLine.length-1 && isDone)
                    timer.stop();
                if(isBack || isForward|| isClear)
                    BackorForward((Graphics2D)gr);
                else
                { 
		if(isDone)
		{
			if(lineNumber < arrayLine.length-1)
			{
				lineNumber++;
				xdyn = arrayLine[lineNumber][0];
				ydyn = arrayLine[lineNumber][1];
			}
		}
		DrawingAnimatedLine((Graphics2D) gr, arrayLine[lineNumber][0], arrayLine[lineNumber][1]);
                }
	}
}
