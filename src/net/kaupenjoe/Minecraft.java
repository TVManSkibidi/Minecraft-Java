package net.minecraft.client;

import abe;
import abp;
import abx;
import aby;
import ach;
import acy;
import adg;
import adj;
import adk;
import adl;
import adt;
import adx;
import aes;
import aff;
import afv;
import afx;
import agp;
import ahm;
import ahy;
import aih;
import aij;
import aim;
import at;
import bo;
import bt;
import c;
import cv;
import cx;
import db;
import dh;
import di;
import dk;
import dr;
import ef;
import eh;
import ej;
import f;
import fa;
import fb;
import ge;
import gk;
import gv;
import gx;
import ha;
import hr;
import hs;
import hw;
import j;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.io.File;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.List;
import jb;
import k;
import ki;
import lk;
import lp;
import me;
import mm;
import mv;
import n;
import nd;
import ng;
import nh;
import nq;
import ny;
import oq;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controllers;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.glu.GLU;
import ov;
import pf;
import qb;
import qd;
import qe;
import ri;
import rj;
import ry;
import si;
import sj;
import ss;
import tk;
import tq;
import uq;
import ut;
import va;
import vg;
import vi;
import vr;
import wa;
import wb;
import ws;
import x;
import xe;
import xw;
import ya;
import yk;
import yu;
import yw;
import yy;
import zh;

public abstract class Minecraft
  implements Runnable
{
  public static byte[] b = new byte[10485760];
  private static Minecraft a;
  public aes c;
  private boolean U = false;
  private boolean V = false;
  public int d;
  public int e;
  private mm W;
  private aij X = new aij(20.0F);
  public ry f;
  public afv g;
  public di h;
  public nq i;
  public f j;
  public dr k = null;
  public String l;
  public Canvas m;
  public boolean n = false;
  public volatile boolean o = false;
  public zh p;
  public abe q;
  public abe r;
  public xe s = null;
  public xw t;
  public adt u;
  private ng Y;
  private int Z = 0;
  private int aa = 0;
  private int ab;
  private int ac;
  public lk v = new lk(this);
  public qd w;
  public boolean x = false;
  public fa y = new fa(0.0F);
  public gv z = null;
  public ki A;
  protected MinecraftApplet B;
  public ahm C = new ahm();
  public hs D;
  public adk E;
  public File F;
  private tq ad;
  public static long[] G = new long[512];
  public static long[] H = new long[512];
  public static int I = 0;
  public static long J = 0L;
  private int ae = 0;
  public tk K;
  private String af;
  private int ag;
  private gk ah = new gk();
  private yu ai = new yu();

  private static File aj = null;

  public volatile boolean L = true;
  public String M = "";

  long N = System.currentTimeMillis();
  int O = 0;

  boolean P = false;

  long Q = -1L;

  private String ak = "root";

  public boolean R = false;

  public boolean S = false;

  long T = System.currentTimeMillis();
  private int al = 0;

  public Minecraft(Component paramComponent, Canvas paramCanvas, MinecraftApplet paramMinecraftApplet, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ny.a();

    this.ac = paramInt2;
    this.U = paramBoolean;
    this.B = paramMinecraftApplet;

    new yk(this, "Timer hack thread");

    this.m = paramCanvas;
    this.d = paramInt1;
    this.e = paramInt2;
    this.U = paramBoolean;

    if ((paramMinecraftApplet == null) || ("true".equals(paramMinecraftApplet.getParameter("stand-alone")))) this.n = false;

    a = this;
  }

  public void b(oq paramoq) {
    this.V = true;
    a(paramoq);
  }

  public abstract void a(oq paramoq);

  public void a(String paramString, int paramInt)
  {
    this.af = paramString;
    this.ag = paramInt;
  }

  public void a()
  {
    Object localObject;
    if (this.m != null) {
      localObject = this.m.getGraphics();
      if (localObject != null) {
        ((Graphics)localObject).setColor(Color.BLACK);
        ((Graphics)localObject).fillRect(0, 0, this.d, this.e);
        ((Graphics)localObject).dispose();
      }
      Display.setParent(this.m);
    }
    else if (this.U) {
      Display.setFullscreen(true);
      this.d = Display.getDisplayMode().getWidth();
      this.e = Display.getDisplayMode().getHeight();
      if (this.d <= 0) this.d = 1;
      if (this.e <= 0) this.e = 1; 
    }
    else {
      Display.setDisplayMode(new DisplayMode(this.d, this.e));
    }

    Display.setTitle("Minecraft Minecraft 1.0.0");
    try
    {
      localObject = new PixelFormat();
      localObject = ((PixelFormat)localObject).withDepthBits(24);
      Display.create((PixelFormat)localObject);
    }
    catch (LWJGLException localLWJGLException)
    {
      localLWJGLException.printStackTrace();
      try {
        Thread.sleep(1000L);
      } catch (InterruptedException localInterruptedException) {
      }
      Display.create();
    }

    adx.a();

    this.F = b();
    this.ad = new adg(new File(this.F, "saves"));

    this.A = new ki(this, this.F);
    this.E = new adk(this, this.F);
    this.p = new zh(this.E, this.A);
    v();

    this.q = new abe(this.A, "/font/default.png", this.p);
    this.r = new abe(this.A, "/font/alternate.png", this.p);

    ya.a(this.p.a("/misc/watercolor.png"));
    ha.a(this.p.a("/misc/grasscolor.png"));
    db.a(this.p.a("/misc/foliagecolor.png"));

    this.u = new adt(this);
    wb.a.f = new n(this);
    this.K = new tk(this.k, this.F);

    ut.f.a(new qb(this));

    v();

    Keyboard.create();
    Mouse.create();
    this.D = new hs(this.m);
    try {
      Controllers.create();
    } catch (Exception localException1) {
      localException1.printStackTrace();
    }

    d("Pre startup");

    GL11.glEnable(3553);
    GL11.glShadeModel(7425);
    GL11.glClearDepth(1.0D);
    GL11.glEnable(2929);
    GL11.glDepthFunc(515);
    GL11.glEnable(3008);
    GL11.glAlphaFunc(516, 0.1F);
    GL11.glCullFace(1029);

    GL11.glMatrixMode(5889);
    GL11.glLoadIdentity();
    GL11.glMatrixMode(5888);
    d("Startup");

    this.W = new mm();
    this.C.a(this.A);

    this.p.a(this.ai);
    this.p.a(this.ah);
    this.p.a(new vr());
    this.p.a(new aih(this));
    this.p.a(new at(this));
    this.p.a(new va());
    this.p.a(new ss());
    this.p.a(new agp(0));
    this.p.a(new agp(1));

    this.g = new afv(this, this.p);

    GL11.glViewport(0, 0, this.d, this.e);

    this.j = new f(this.f, this.p);
    try {
      this.Y = new ng(this.F, this);
      this.Y.start();
    }
    catch (Exception localException2) {
    }
    d("Post startup");
    this.w = new qd(this);

    if (this.af != null)
      a(new ri(this, this.af, this.ag));
    else {
      a(new eh());
    }
    this.t = new xw(this);
  }

  private void v() {
    ef localef = new ef(this.A, this.d, this.e);

    GL11.glClear(16640);
    GL11.glMatrixMode(5889);
    GL11.glLoadIdentity();
    GL11.glOrtho(0.0D, localef.a, localef.b, 0.0D, 1000.0D, 3000.0D);
    GL11.glMatrixMode(5888);
    GL11.glLoadIdentity();
    GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
    GL11.glViewport(0, 0, this.d, this.e);
    GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);

    cv localcv = cv.a;

    GL11.glDisable(2896);
    GL11.glEnable(3553);
    GL11.glDisable(2912);
    GL11.glBindTexture(3553, this.p.b("/title/mojang.png"));
    localcv.b();
    localcv.c(16777215);
    localcv.a(0.0D, this.e, 0.0D, 0.0D, 0.0D);
    localcv.a(this.d, this.e, 0.0D, 0.0D, 0.0D);
    localcv.a(this.d, 0.0D, 0.0D, 0.0D, 0.0D);
    localcv.a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
    localcv.a();

    int i1 = 256;
    int i2 = 256;
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    localcv.c(16777215);
    a((localef.a() - i1) / 2, (localef.b() - i2) / 2, 0, 0, i1, i2);
    GL11.glDisable(2896);
    GL11.glDisable(2912);

    GL11.glEnable(3008);
    GL11.glAlphaFunc(516, 0.1F);

    Display.swapBuffers();
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    float f1 = 0.0039063F;
    float f2 = 0.0039063F;
    cv localcv = cv.a;
    localcv.b();
    localcv.a(paramInt1 + 0, paramInt2 + paramInt6, 0.0D, (paramInt3 + 0) * f1, (paramInt4 + paramInt6) * f2);
    localcv.a(paramInt1 + paramInt5, paramInt2 + paramInt6, 0.0D, (paramInt3 + paramInt5) * f1, (paramInt4 + paramInt6) * f2);
    localcv.a(paramInt1 + paramInt5, paramInt2 + 0, 0.0D, (paramInt3 + paramInt5) * f1, (paramInt4 + 0) * f2);
    localcv.a(paramInt1 + 0, paramInt2 + 0, 0.0D, (paramInt3 + 0) * f1, (paramInt4 + 0) * f2);
    localcv.a();
  }

  public static File b()
  {
    if (aj == null) aj = a("minecraft");
    return aj;
  }

  public static File a(String paramString) {
    String str1 = System.getProperty("user.home", ".");
    File localFile;
    switch (qr.a[w().ordinal()]) {
    case 1:
    case 2:
      localFile = new File(str1, '.' + paramString + '/');
      break;
    case 3:
      String str2 = System.getenv("APPDATA");
      if (str2 != null) localFile = new File(str2, "." + paramString + '/'); else
        localFile = new File(str1, '.' + paramString + '/');
      break;
    case 4:
      localFile = new File(str1, "Library/Application Support/" + paramString);
      break;
    default:
      localFile = new File(str1, paramString + '/');
    }
    if ((!localFile.exists()) && (!localFile.mkdirs())) throw new RuntimeException("The working directory could not be created: " + localFile);
    return localFile;
  }

  private static qe w() {
    String str = System.getProperty("os.name").toLowerCase();
    if (str.contains("win")) return qe.c;
    if (str.contains("mac")) return qe.d;
    if (str.contains("solaris")) return qe.b;
    if (str.contains("sunos")) return qe.b;
    if (str.contains("linux")) return qe.a;
    if (str.contains("unix")) return qe.a;
    return qe.e;
  }

  public tq c() {
    return this.ad;
  }

  public void a(xe paramxe) {
    if ((this.s instanceof aff)) return;

    if (this.s != null) {
      this.s.d();
    }

    if ((paramxe instanceof eh)) {
      this.K.b();
    }
    this.K.c();

    if ((paramxe == null) && (this.f == null))
      paramxe = new eh();
    else if ((paramxe == null) && (this.h.ag() <= 0)) {
      paramxe = new j();
    }

    if ((paramxe instanceof eh)) {
      this.A.F = false;
      this.w.b();
    }

    this.s = paramxe;
    if (paramxe != null) {
      h();
      ef localef = new ef(this.A, this.d, this.e);
      int i1 = localef.a();
      int i2 = localef.b();
      paramxe.a(this, i1, i2);
      this.x = false;
    } else {
      g();
    }
  }

  private void d(String paramString) {
    int i1 = GL11.glGetError();
    if (i1 != 0) {
      String str = GLU.gluErrorString(i1);
      System.out.println("########## GL ERROR ##########");
      System.out.println("@ " + paramString);
      System.out.println(i1 + ": " + str);
    }
  }

  public void d()
  {
    try {
      this.K.b();
      this.K.c();

      if (this.B != null)
        this.B.c();
      try
      {
        if (this.Y != null)
          this.Y.b();
      }
      catch (Exception localException)
      {
      }
      System.out.println("Stopping!");
      try {
        a(null);
      }
      catch (Throwable localThrowable1) {
      }
      try {
        bt.a();
      }
      catch (Throwable localThrowable2) {
      }
      this.C.b();
      Mouse.destroy();
      Keyboard.destroy();
    } finally {
      Display.destroy();
      if (!this.V) System.exit(0);
    }
    System.gc();
  }

  public void run()
  {
    this.L = true;
    try {
      a();
    } catch (Exception localException) {
      localException.printStackTrace();
      b(new oq("Failed to start game", localException));
      return;
    }

    try
    {
      while (this.L)
        try {
          x();
        } catch (adl localadl) {
          this.f = null;
          a(null);
          a(new ach());
        } catch (OutOfMemoryError localOutOfMemoryError) {
          e();
          a(new ov());
          System.gc();
        }
    } catch (adj localadj) {
    }
    catch (Throwable localThrowable) {
      e();
      localThrowable.printStackTrace();
      b(new oq("Unexpected error", localThrowable));
    } finally {
      d();
    }
  }

  private void x() {
    if ((this.B != null) && (!this.B.isActive())) {
      this.L = false;
      return;
    }
    c.b();
    fb.b();

    pf.a("root");
    if ((this.m == null) && (Display.isCloseRequested())) {
      f();
    }

    if ((this.o) && (this.f != null)) {
      float f1 = this.X.c;
      this.X.a();
      this.X.c = f1;
    } else {
      this.X.a();
    }

    long l1 = System.nanoTime();
    pf.a("tick");
    for (int i1 = 0; i1 < this.X.b; i1++) {
      this.Z += 1;
      try {
        k();
      } catch (adl localadl) {
        this.f = null;
        a(null);
        a(new ach());
      }
    }
    pf.b();
    long l2 = System.nanoTime() - l1;
    d("Pre render");

    acr.b = this.A.j;

    pf.a("sound");
    this.C.a(this.h, this.X.c);
    pf.c("updatelights");
    if (this.f != null) this.f.F();
    pf.b();

    pf.a("render");
    pf.a("display");
    GL11.glEnable(3553);
    if (!Keyboard.isKeyDown(65)) Display.update();
    if ((this.h != null) && (this.h.L())) {
      this.A.E = 0;
    }
    pf.b();
    if (!this.x) {
      pf.a("gameMode");
      if (this.c != null) this.c.a(this.X.c);
      pf.c("gameRenderer");
      this.u.b(this.X.c);
      pf.b();
    }
    GL11.glFlush();

    pf.b();

    if ((!Display.isActive()) && 
      (this.U)) {
      j();
    }

    pf.b();
    if (this.A.F) {
      if (!pf.a) {
        pf.a();
      }

      pf.a = true;

      a(l2);
    } else {
      pf.a = false;

      this.Q = System.nanoTime();
    }

    this.v.a();

    pf.a("root");
    Thread.yield();

    if (Keyboard.isKeyDown(65)) Display.update();

    y();

    if ((this.m != null) && (!this.U) && (
      (this.m.getWidth() != this.d) || (this.m.getHeight() != this.e))) {
      this.d = this.m.getWidth();
      this.e = this.m.getHeight();
      if (this.d <= 0) this.d = 1;
      if (this.e <= 0) this.e = 1;

      a(this.d, this.e);
    }

    d("Post render");
    this.O += 1;
    this.o = ((!l()) && (this.s != null) && (this.s.b()));

    while (System.currentTimeMillis() >= this.N + 1000L) {
      this.M = (this.O + " fps, " + ge.b + " chunk updates");
      ge.b = 0;
      this.N += 1000L;
      this.O = 0;
    }
    pf.b();
  }

  public void e()
  {
    try {
      b = new byte[0];
      this.g.e();
    } catch (Throwable localThrowable1) {
    }
    try {
      System.gc();
      c.a();
      fb.a();
    } catch (Throwable localThrowable2) {
    }
    try {
      System.gc();
      a(null);
    } catch (Throwable localThrowable3) {
    }
    System.gc();
  }

  private void y()
  {
    if (Keyboard.isKeyDown(60)) {
      if (!this.P) {
        this.P = true;
        this.w.a(abx.a(aj, this.d, this.e));
      }
    }
    else
    {
      this.P = false;
    }
  }

  private void b(int paramInt)
  {
    List localList = pf.b(this.ak);
    if ((localList == null) || (localList.size() == 0)) return;

    afx localafx = (afx)localList.remove(0);
    if (paramInt == 0) {
      if (localafx.c.length() > 0) {
        int i1 = this.ak.lastIndexOf(".");
        if (i1 >= 0) this.ak = this.ak.substring(0, i1); 
      }
    }
    else {
      paramInt--;
      if ((paramInt < localList.size()) && (!((afx)localList.get(paramInt)).c.equals("unspecified"))) {
        if (this.ak.length() > 0) this.ak += ".";
        this.ak += ((afx)localList.get(paramInt)).c;
      }
    }
  }

  private void a(long paramLong)
  {
    List localList = pf.b(this.ak);
    afx localafx1 = (afx)localList.remove(0);

    long l1 = 16666666L;
    if (this.Q == -1L) {
      this.Q = System.nanoTime();
    }
    long l2 = System.nanoTime();
    H[(I & G.length - 1)] = paramLong;
    G[(I++ & G.length - 1)] = (l2 - this.Q);
    this.Q = l2;

    GL11.glClear(256);
    GL11.glMatrixMode(5889);
    GL11.glEnable(2903);
    GL11.glLoadIdentity();
    GL11.glOrtho(0.0D, this.d, this.e, 0.0D, 1000.0D, 3000.0D);
    GL11.glMatrixMode(5888);
    GL11.glLoadIdentity();
    GL11.glTranslatef(0.0F, 0.0F, -2000.0F);

    GL11.glLineWidth(1.0F);
    GL11.glDisable(3553);
    cv localcv = cv.a;
    localcv.a(7);
    int i1 = (int)(l1 / 200000L);
    localcv.c(536870912);
    localcv.a(0.0D, this.e - i1, 0.0D);
    localcv.a(0.0D, this.e, 0.0D);
    localcv.a(G.length, this.e, 0.0D);
    localcv.a(G.length, this.e - i1, 0.0D);

    localcv.c(538968064);
    localcv.a(0.0D, this.e - i1 * 2, 0.0D);
    localcv.a(0.0D, this.e - i1, 0.0D);
    localcv.a(G.length, this.e - i1, 0.0D);
    localcv.a(G.length, this.e - i1 * 2, 0.0D);

    localcv.a();
    long l3 = 0L;
    for (int i2 = 0; i2 < G.length; i2++) {
      l3 += G[i2];
    }
    i2 = (int)(l3 / 200000L / G.length);
    localcv.a(7);
    localcv.c(541065216);
    localcv.a(0.0D, this.e - i2, 0.0D);
    localcv.a(0.0D, this.e, 0.0D);
    localcv.a(G.length, this.e, 0.0D);
    localcv.a(G.length, this.e - i2, 0.0D);
    localcv.a();
    localcv.a(1);
    for (int i3 = 0; i3 < G.length; i3++) {
      i4 = (i3 - I & G.length - 1) * 255 / G.length;
      i5 = i4 * i4 / 255;
      i5 = i5 * i5 / 255;
      int i6 = i5 * i5 / 255;
      i6 = i6 * i6 / 255;
      if (G[i3] > l1)
        localcv.c(-16777216 + i5 * 65536);
      else {
        localcv.c(-16777216 + i5 * 256);
      }

      long l4 = G[i3] / 200000L;
      long l5 = H[i3] / 200000L;

      localcv.a(i3 + 0.5F, (float)(this.e - l4) + 0.5F, 0.0D);
      localcv.a(i3 + 0.5F, this.e + 0.5F, 0.0D);

      localcv.c(-16777216 + i5 * 65536 + i5 * 256 + i5 * 1);

      localcv.a(i3 + 0.5F, (float)(this.e - l4) + 0.5F, 0.0D);
      localcv.a(i3 + 0.5F, (float)(this.e - (l4 - l5)) + 0.5F, 0.0D);
    }
    localcv.a();

    i3 = 160;
    int i4 = this.d - i3 - 10;
    int i5 = this.e - i3 * 2;
    GL11.glEnable(3042);
    localcv.b();
    localcv.a(0, 200);
    localcv.a(i4 - i3 * 1.1F, i5 - i3 * 0.6F - 16.0F, 0.0D);
    localcv.a(i4 - i3 * 1.1F, i5 + i3 * 2, 0.0D);
    localcv.a(i4 + i3 * 1.1F, i5 + i3 * 2, 0.0D);
    localcv.a(i4 + i3 * 1.1F, i5 - i3 * 0.6F - 16.0F, 0.0D);
    localcv.a();
    GL11.glDisable(3042);

    double d1 = 0.0D;
    for (int i7 = 0; i7 < localList.size(); i7++) {
      localObject = (afx)localList.get(i7);

      i9 = me.c(((afx)localObject).a / 4.0D) + 1;

      localcv.a(6);
      localcv.c(((afx)localObject).a());
      localcv.a(i4, i5, 0.0D);
      float f1;
      float f2;
      float f3;
      for (int i10 = i9; i10 >= 0; i10--) {
        f1 = (float)((d1 + ((afx)localObject).a * i10 / i9) * 3.141592741012573D * 2.0D / 100.0D);
        f2 = me.a(f1) * i3;
        f3 = me.b(f1) * i3 * 0.5F;
        localcv.a(i4 + f2, i5 - f3, 0.0D);
      }
      localcv.a();
      localcv.a(5);
      localcv.c((((afx)localObject).a() & 0xFEFEFE) >> 1);
      for (i10 = i9; i10 >= 0; i10--) {
        f1 = (float)((d1 + ((afx)localObject).a * i10 / i9) * 3.141592741012573D * 2.0D / 100.0D);
        f2 = me.a(f1) * i3;
        f3 = me.b(f1) * i3 * 0.5F;
        localcv.a(i4 + f2, i5 - f3, 0.0D);
        localcv.a(i4 + f2, i5 - f3 + 10.0F, 0.0D);
      }
      localcv.a();

      d1 += ((afx)localObject).a;
    }

    DecimalFormat localDecimalFormat = new DecimalFormat("##0.00");

    GL11.glEnable(3553);

    Object localObject = "";
    if (!localafx1.c.equals("unspecified")) {
      localObject = (String)localObject + "[0] ";
    }
    if (localafx1.c.length() == 0)
      localObject = (String)localObject + "ROOT ";
    else {
      localObject = (String)localObject + localafx1.c + " ";
    }
    int i9 = 16777215;
    this.q.a((String)localObject, i4 - i3, i5 - i3 / 2 - 16, i9);
    this.q.a(localObject = localDecimalFormat.format(localafx1.b) + "%", i4 + i3 - this.q.a((String)localObject), i5 - i3 / 2 - 16, i9);

    for (int i8 = 0; i8 < localList.size(); i8++) {
      afx localafx2 = (afx)localList.get(i8);

      String str = "";
      if (!localafx2.c.equals("unspecified"))
        str = str + "[" + (i8 + 1) + "] ";
      else {
        str = str + "[?] ";
      }

      str = str + localafx2.c;
      this.q.a(str, i4 - i3, i5 + i3 / 2 + i8 * 8 + 20, localafx2.a());
      this.q.a(str = localDecimalFormat.format(localafx2.a) + "%", i4 + i3 - 50 - this.q.a(str), i5 + i3 / 2 + i8 * 8 + 20, localafx2.a());
      this.q.a(str = localDecimalFormat.format(localafx2.b) + "%", i4 + i3 - this.q.a(str), i5 + i3 / 2 + i8 * 8 + 20, localafx2.a());
    }
  }

  public void f()
  {
    this.L = false;
  }

  public void g()
  {
    if (!Display.isActive()) return;
    if (this.R) return;
    this.R = true;
    this.D.a();
    a(null);
    this.aa = 10000;
  }

  public void h() {
    if (!this.R) return;
    aby.a();
    this.R = false;
    this.D.b();
  }

  public void i() {
    if (this.s != null) return;

    a(new nd());
  }

  private void a(int paramInt, boolean paramBoolean) {
    if (!paramBoolean) this.aa = 0;

    if ((paramInt == 0) && (this.aa > 0)) return;

    if ((paramBoolean) && (this.z != null) && (this.z.a == bo.a) && (paramInt == 0)) {
      int i1 = this.z.b;
      int i2 = this.z.c;
      int i3 = this.z.d;
      this.c.c(i1, i2, i3, this.z.e);
      if (this.h.e(i1, i2, i3)) {
        this.j.a(i1, i2, i3, this.z.e);
        this.h.m_();
      }
    } else {
      this.c.b();
    }
  }

  private void c(int paramInt) {
    if ((paramInt == 0) && (this.aa > 0)) return;
    if (paramInt == 0) {
      this.h.m_();
    }

    if (paramInt == 1) this.ae = 4;

    int i1 = 1;

    dk localdk1 = this.h.by.a();

    if (this.z == null) {
      if ((paramInt == 0) && (this.c.f())) this.aa = 10; 
    }
    else if (this.z.a == bo.b) {
      if (paramInt == 0) {
        this.c.a(this.h, this.z.g);
      }
      if (paramInt == 1)
        this.c.b(this.h, this.z.g);
    }
    else if (this.z.a == bo.a) {
      int i2 = this.z.b;
      int i3 = this.z.c;
      int i4 = this.z.d;
      int i5 = this.z.e;

      if (paramInt == 0) {
        this.c.b(i2, i3, i4, this.z.e);
      } else {
        dk localdk3 = localdk1;
        int i6 = localdk3 != null ? localdk3.a : 0;
        if (this.c.a(this.h, this.f, localdk3, i2, i3, i4, i5)) {
          i1 = 0;
          this.h.m_();
        }
        if (localdk3 == null) {
          return;
        }

        if (localdk3.a == 0)
          this.h.by.a[this.h.by.c] = null;
        else if ((localdk3.a != i6) || (this.c.g())) {
          this.u.c.b();
        }
      }
    }

    if ((i1 != 0) && (paramInt == 1)) {
      dk localdk2 = this.h.by.a();
      if ((localdk2 != null) && 
        (this.c.a(this.h, this.f, localdk2)))
        this.u.c.c();
    }
  }

  public void j()
  {
    try
    {
      this.U = (!this.U);
      if (this.U) {
        Display.setDisplayMode(Display.getDesktopDisplayMode());
        this.d = Display.getDisplayMode().getWidth();
        this.e = Display.getDisplayMode().getHeight();
        if (this.d <= 0) this.d = 1;
        if (this.e <= 0) this.e = 1; 
      }
      else {
        if (this.m != null) {
          this.d = this.m.getWidth();
          this.e = this.m.getHeight();
        } else {
          this.d = this.ab;
          this.e = this.ac;
        }
        if (this.d <= 0) this.d = 1;
        if (this.e <= 0) this.e = 1;
      }
      if (this.s != null) {
        a(this.d, this.e);
      }
      Display.setFullscreen(this.U);
      Display.update();
    } catch (Exception localException) {
      localException.printStackTrace();
    }
  }

  private void a(int paramInt1, int paramInt2) {
    if (paramInt1 <= 0) paramInt1 = 1;
    if (paramInt2 <= 0) paramInt2 = 1;
    this.d = paramInt1;
    this.e = paramInt2;

    if (this.s != null) {
      ef localef = new ef(this.A, paramInt1, paramInt2);
      int i1 = localef.a();
      int i2 = localef.b();
      this.s.a(this, i1, i2);
    }
  }

  private void z()
  {
    new hr(this).start();
  }

  public void k()
  {
    if (this.ae > 0) this.ae -= 1;
    if (this.Z == 6000) {
      z();
    }

    pf.a("stats");
    this.K.d();
    pf.c("gui");
    if (!this.o) this.w.a();
    pf.c("pick");
    this.u.a(1.0F);
    pf.c("centerChunkSource");
    int i2;
    if (this.h != null) {
      ej localej = this.f.x();
      if ((localej instanceof mv)) {
        mv localmv = (mv)localej;

        i2 = me.d((int)this.h.s) >> 4;
        int i3 = me.d((int)this.h.u) >> 4;
        localmv.d(i2, i3);
      }

    }

    pf.c("gameMode");
    if ((!this.o) && (this.f != null)) this.c.d();
    GL11.glBindTexture(3553, this.p.b("/terrain.png"));
    pf.c("textures");
    if (!this.o) this.p.a();

    if ((this.s == null) && (this.h != null)) {
      if (this.h.ag() <= 0)
        a(null);
      else if ((this.h.ar()) && (this.f != null) && (this.f.I))
        a(new rj());
    }
    else if ((this.s != null) && ((this.s instanceof rj)) && (!this.h.ar())) {
      a(null);
    }

    if (this.s != null) {
      this.aa = 10000;
    }

    if (this.s != null) {
      this.s.g();
      if (this.s != null) {
        this.s.r.a();
        this.s.s_();
      }
    }

    if ((this.s == null) || (this.s.p)) {
      pf.c("mouse");
      while (Mouse.next()) {
        aby.a(Mouse.getEventButton() - 100, Mouse.getEventButtonState());
        if (Mouse.getEventButtonState()) {
          aby.a(Mouse.getEventButton() - 100);
        }
        long l1 = System.currentTimeMillis() - this.T;
        if (l1 > 200L)
          continue;
        i2 = Mouse.getEventDWheel();
        if (i2 != 0) {
          this.h.by.a(i2);

          if (this.A.H) {
            if (i2 > 0) i2 = 1;
            if (i2 < 0) i2 = -1;

            this.A.K += i2 * 0.25F;
          }
        }

        if (this.s == null) {
          if ((!this.R) && (Mouse.getEventButtonState()))
            g();
        }
        else if (this.s != null) {
          this.s.h();
        }
      }

      if (this.aa > 0) this.aa -= 1;

      pf.c("keyboard");
      while (Keyboard.next()) {
        aby.a(Keyboard.getEventKey(), Keyboard.getEventKeyState());
        if (Keyboard.getEventKeyState()) {
          aby.a(Keyboard.getEventKey());
        }

        if (Keyboard.getEventKeyState()) {
          if (Keyboard.getEventKey() == 87) {
            j();
            continue;
          }

          if (this.s != null) {
            this.s.i();
          } else {
            if (Keyboard.getEventKey() == 1) {
              i();
            }

            if ((Keyboard.getEventKey() == 31) && (Keyboard.isKeyDown(61))) {
              A();
            }
            if ((Keyboard.getEventKey() == 20) && (Keyboard.isKeyDown(61))) {
              this.p.b();
            }
            if ((Keyboard.getEventKey() == 33) && (Keyboard.isKeyDown(61))) {
              i1 = Keyboard.isKeyDown(42) | Keyboard.isKeyDown(54);
              this.A.a(lp.g, i1 != 0 ? -1 : 1);
            }
            if ((Keyboard.getEventKey() == 30) && (Keyboard.isKeyDown(61))) {
              this.g.a();
            }

            if (Keyboard.getEventKey() == 59) {
              this.A.D = (!this.A.D);
            }
            if (Keyboard.getEventKey() == 61) {
              this.A.F = (!this.A.F);
            }
            if (Keyboard.getEventKey() == 63) {
              this.A.E += 1;
              if (this.A.E > 2) {
                this.A.E = 0;
              }
            }
            if (Keyboard.getEventKey() == 66) {
              this.A.I = (!this.A.I);
            }

          }

          for (int i1 = 0; i1 < 9; i1++) {
            if (Keyboard.getEventKey() != 2 + i1) continue; this.h.by.c = i1;
          }
          if (this.A.F) {
            if (Keyboard.getEventKey() == 11) {
              b(0);
            }
            for (i1 = 0; i1 < 9; i1++) {
              if (Keyboard.getEventKey() == 2 + i1) {
                b(i1 + 1);
              }
            }
          }
        }
      }

      while (this.A.s.c())
        a(new hw(this.h));
      while (this.A.t.c())
        this.h.l_();
      while ((l()) && (this.A.u.c()))
      {
        a(new gx());
      }
      if (this.h.az()) {
        if (!this.A.x.e) {
          this.c.a_(this.h);
        }

        while (this.A.w.c());
        while (this.A.x.c());
        while (this.A.z.c());
      }
      while (this.A.w.c()) {
        c(0);
      }
      while (this.A.x.c()) {
        c(1);
      }
      while (this.A.z.c()) {
        B();
      }

      if ((this.A.x.e) && (this.ae == 0) && (!this.h.az())) {
        c(1);
      }

      a(0, (this.s == null) && (this.A.w.e) && (this.R));
    }

    if (this.f != null) {
      if (this.h != null) {
        this.al += 1;
        if (this.al == 30) {
          this.al = 0;
          this.f.g(this.h);
        }
      }
      if (this.f.z().s())
        this.f.v = 3;
      else {
        this.f.v = this.A.C;
      }
      if (this.f.I) this.f.v = 1;

      pf.c("gameRenderer");
      if (!this.o) this.u.a();
      pf.c("levelRenderer");
      if (!this.o) this.g.d();

      pf.c("level");
      if (!this.o) {
        if (this.f.s > 0) this.f.s -= 1;
        this.f.m();
      }
      if ((!this.o) || (l())) {
        this.f.a(this.f.v > 0, true);
        this.f.c();
      }
      pf.c("animateTick");
      if ((!this.o) && (this.f != null)) this.f.t(me.c(this.h.s), me.c(this.h.t), me.c(this.h.u));
      pf.c("particles");
      if (!this.o) this.j.a();

    }

    pf.b();

    this.T = System.currentTimeMillis();
  }

  private void A() {
    System.out.println("FORCING RELOAD!");
    this.C = new ahm();
    this.C.a(this.A);
    this.Y.a();
  }

  public boolean l() {
    return (this.f != null) && (this.f.I);
  }

  public void a(String paramString1, String paramString2, yw paramyw)
  {
    a(null);
    System.gc();

    if (this.ad.c(paramString1)) {
      b(paramString1, paramString2);
    } else {
      if (this.t != null) {
        this.t.c("Switching level");
        this.t.b("");
      }

      nh localnh = this.ad.a(paramString1, false);
      ry localry = null;

      localry = new ry(localnh, paramString2, paramyw);

      if (localry.x) {
        this.K.a(ny.g, 1);
        this.K.a(ny.f, 1);
        a(localry, "Generating level");
      } else {
        this.K.a(ny.h, 1);
        this.K.a(ny.f, 1);
        a(localry, "Loading level");
      }
    }
  }

  public void a(int paramInt) {
    int i1 = this.h.bK;

    this.h.bK = paramInt;
    this.f.b(this.h);
    this.h.K = false;

    double d1 = this.h.s;
    double d2 = this.h.u;
    double d3 = 1.0D;
    if ((i1 > -1) && (this.h.bK == -1))
      d3 = 0.125D;
    else if ((i1 == -1) && (this.h.bK > -1)) {
      d3 = 8.0D;
    }
    d1 *= d3;
    d2 *= d3;
    ry localry;
    if (this.h.bK == -1) {
      this.h.c(d1, this.h.t, d2, this.h.y, this.h.z);
      if (this.h.K()) {
        this.f.a(this.h, false);
      }

      localry = null;

      localry = new ry(this.f, k.a(this.h.bK));

      a(localry, "Entering the Nether", this.h);
    } else if (this.h.bK == 0) {
      if (this.h.K()) {
        this.h.c(d1, this.h.t, d2, this.h.y, this.h.z);
        this.f.a(this.h, false);
      }

      localry = null;

      localry = new ry(this.f, k.a(this.h.bK));

      if (i1 == -1) a(localry, "Leaving the Nether", this.h); else
        a(localry, "Leaving the End", this.h);
    } else {
      localry = null;

      localry = new ry(this.f, k.a(this.h.bK));

      dh localdh = localry.j();

      d1 = localdh.a;
      this.h.t = localdh.b;
      d2 = localdh.c;

      this.h.c(d1, this.h.t, d2, 90.0F, 0.0F);
      if (this.h.K()) {
        localry.a(this.h, false);
      }

      a(localry, "Entering the End", this.h);
    }

    this.h.o = this.f;
    System.out.println("Teleported to " + this.f.y.g);
    if ((this.h.K()) && (i1 < 1)) {
      this.h.c(d1, this.h.t, d2, this.h.y, this.h.z);
      this.f.a(this.h, false);
      new aim().a(this.f, this.h);
    }
  }

  public void b(String paramString)
  {
    this.f = null;
    a(null, paramString);
  }

  public void a(ry paramry) {
    a(paramry, "");
  }

  public void a(ry paramry, String paramString) {
    a(paramry, paramString, null);
  }

  public void a(ry paramry, String paramString, vi paramvi) {
    this.K.b();
    this.K.c();

    this.i = null;

    if (this.t != null) {
      this.t.c(paramString);
      this.t.b("");
    }

    this.C.a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);

    if (this.f != null) this.f.a(this.t);
    this.f = paramry;

    if (paramry != null) {
      if (this.c != null) this.c.a(paramry);

      if (!l()) {
        if (paramvi == null) {
          this.h = ((di)paramry.a(di.class));
        }
      }
      else if (this.h != null) {
        this.h.u();

        if (paramry != null) {
          paramry.a(this.h);
        }

      }

      if (!paramry.I) e(paramString);

      if (this.h == null) {
        this.h = ((di)this.c.b(paramry));
        this.h.u();
        this.c.a(this.h);
      }

      this.h.b = new wa(this.A);
      if (this.g != null) this.g.a(paramry);
      if (this.j != null) this.j.a(paramry);

      if (paramvi != null) {
        paramry.k();
      }
      ej localej = paramry.x();
      if ((localej instanceof mv)) {
        mv localmv = (mv)localej;

        int i1 = me.d((int)this.h.s) >> 4;
        int i2 = me.d((int)this.h.u) >> 4;

        localmv.d(i1, i2);
      }
      paramry.a(this.h);
      this.c.d(this.h);

      if (paramry.x) {
        paramry.a(this.t);
      }
      this.i = this.h;
    } else {
      this.ad.c();
      this.h = null;
    }

    System.gc();
    this.T = 0L;
  }

  private void b(String paramString1, String paramString2) {
    this.t.c("Converting World to " + this.ad.a());
    this.t.b("This may take a while :)");

    this.ad.a(paramString1, this.t);

    a(paramString1, paramString2, new yw(0L, 0, true, false));
  }

  private void e(String paramString)
  {
    if (this.t != null) {
      this.t.c(paramString);
      this.t.b("Building terrain");
    }
    int i1 = 128;
    if (this.c.i()) i1 = 64;
    int i2 = 0;
    int i3 = i1 * 2 / 16 + 1;
    i3 *= i3;
    ej localej = this.f.x();

    dh localdh = this.f.v();
    if (this.h != null) {
      localdh.a = (int)this.h.s;
      localdh.c = (int)this.h.u;
    }

    if ((localej instanceof mv)) {
      mv localmv = (mv)localej;

      localmv.d(localdh.a >> 4, localdh.c >> 4);
    }

    for (int i4 = -i1; i4 <= i1; i4 += 16) {
      for (int i5 = -i1; i5 <= i1; i5 += 16) {
        if (this.t != null) this.t.a(i2++ * 100 / i3);
        this.f.a(localdh.a + i4, 64, localdh.c + i5);
        while ((!this.c.i()) && 
          (this.f.F()));
      }
    }

    if (!this.c.i()) {
      if (this.t != null) this.t.b("Simulating world for a bit");
      i3 = 2000;
      this.f.r();
    }
  }

  public void a(String paramString, File paramFile)
  {
    int i1 = paramString.indexOf("/");
    String str = paramString.substring(0, i1);
    paramString = paramString.substring(i1 + 1);
    if (str.equalsIgnoreCase("sound"))
      this.C.a(paramString, paramFile);
    else if (str.equalsIgnoreCase("newsound"))
      this.C.a(paramString, paramFile);
    else if (str.equalsIgnoreCase("streaming"))
      this.C.b(paramString, paramFile);
    else if (str.equalsIgnoreCase("music"))
      this.C.c(paramString, paramFile);
    else if (str.equalsIgnoreCase("newmusic"))
      this.C.c(paramString, paramFile);
  }

  public String m()
  {
    return this.g.b();
  }

  public String n() {
    return this.g.c();
  }

  public String o() {
    return this.f.o();
  }

  public String p() {
    return "P: " + this.j.b() + ". T: " + this.f.n();
  }

  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2) {
    if ((!this.f.I) && 
      (!this.f.y.d())) {
      a(0);
    }

    dh localdh1 = null;
    dh localdh2 = null;
    int i1 = 1;

    if ((this.h != null) && (!paramBoolean1)) {
      localdh1 = this.h.aM();
      if (localdh1 != null) {
        localdh2 = vi.a(this.f, localdh1);

        if (localdh2 == null) {
          this.h.b("tile.bed.notValid");
        }
      }
    }
    if (localdh2 == null) {
      localdh2 = this.f.v();
      i1 = 0;
    }

    ej localej = this.f.x();
    if ((localej instanceof mv)) {
      mv localmv = (mv)localej;
      localmv.d(localdh2.a >> 4, localdh2.c >> 4);
    }

    this.f.e();
    this.f.w();

    int i2 = 0;
    if (this.h != null) {
      i2 = this.h.j;
      this.f.b(this.h);
    }

    di localdi = this.h;
    this.i = null;
    this.h = ((di)this.c.b(this.f));
    if (paramBoolean2) {
      this.h.d(localdi);
    }
    this.h.bK = paramInt;
    this.i = this.h;
    this.h.u();
    if (i1 != 0) {
      this.h.a(localdh1);
      this.h.c(localdh2.a + 0.5F, localdh2.b + 0.1F, localdh2.c + 0.5F, 0.0F, 0.0F);
    }
    this.c.a(this.h);
    this.f.a(this.h);

    this.h.b = new wa(this.A);
    this.h.j = i2;
    this.h.r();
    this.c.d(this.h);
    e("Respawning");

    if ((this.s instanceof j)) a(null); 
  }

  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }

  public static void a(String paramString1, String paramString2, String paramString3) {
    boolean bool = false;
    String str = paramString1;

    Frame localFrame = new Frame("Minecraft");
    Canvas localCanvas = new Canvas();
    localFrame.setLayout(new BorderLayout());

    localFrame.add(localCanvas, "Center");

    localCanvas.setPreferredSize(new Dimension(854, 480));
    localFrame.pack();
    localFrame.setLocationRelativeTo(null);

    ahy localahy = new ahy(localFrame, localCanvas, null, 854, 480, bool, localFrame);

    Thread localThread = new Thread(localahy, "Minecraft main thread");
    localThread.setPriority(10);
    localahy.l = "www.minecraft.net";

    if ((str != null) && (paramString2 != null))
      localahy.k = new dr(str, paramString2);
    else {
      localahy.k = new dr("Player" + System.currentTimeMillis() % 1000L, "");
    }

    if (paramString3 != null) {
      String[] arrayOfString = paramString3.split(":");
      localahy.a(arrayOfString[0], Integer.parseInt(arrayOfString[1]));
    }

    localFrame.setVisible(true);
    localFrame.addWindowListener(new sj(localahy, localThread));

    localThread.start();
  }

  public abp q() {
    if ((this.h instanceof cx)) {
      return ((cx)this.h).a;
    }
    return null;
  }

  public static void main(String[] paramArrayOfString)
  {
    String str1 = null;
    String str2 = null;

    str1 = "Player" + System.currentTimeMillis() % 1000L;
    if (paramArrayOfString.length > 0) str1 = paramArrayOfString[0];
    str2 = "-";
    if (paramArrayOfString.length > 1) str2 = paramArrayOfString[1];

    a(str1, str2);
  }

  public static boolean r()
  {
    return (a == null) || (!a.A.D);
  }

  public static boolean s()
  {
    return (a != null) && (a.A.j);
  }

  public static boolean t() {
    return (a != null) && (a.A.k);
  }

  public static boolean u() {
    return (a != null) && (a.A.F);
  }

  public boolean c(String paramString)
  {
    if (paramString.startsWith("/"));
    return false;
  }

  private void B() {
    if (this.z != null) {
      int i1 = this.f.a(this.z.b, this.z.c, this.z.d);
      if (i1 == yy.u.bM) i1 = yy.v.bM;
      if (i1 == yy.aj.bM) i1 = yy.ak.bM;
      if (i1 == yy.z.bM) i1 = yy.t.bM;

      int i2 = 0;
      boolean bool = false;
      if (acy.d[i1].f()) {
        i2 = this.f.d(this.z.b, this.z.c, this.z.d);
        bool = true;
      }

      this.h.by.a(i1, i2, bool, this.c instanceof uq);
    }
  }
}
