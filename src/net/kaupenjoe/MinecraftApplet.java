package net.minecraft.client;

import dr;
import ep;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.io.PrintStream;
import java.net.URL;
import nm;

public class MinecraftApplet extends Applet
{
  private Canvas a;
  private Minecraft b;
  private Thread c = null;

  public void init() {
    this.a = new ep(this);

    boolean bool = false;
    if (getParameter("fullscreen") != null) {
      bool = getParameter("fullscreen").equalsIgnoreCase("true");
    }

    this.b = new nm(this, this, this.a, this, getWidth(), getHeight(), bool);

    this.b.l = getDocumentBase().getHost();
    if (getDocumentBase().getPort() > 0)
    {
      Minecraft tmp97_94 = this.b; tmp97_94.l = (tmp97_94.l + ":" + getDocumentBase().getPort());
    }

    if ((getParameter("username") != null) && (getParameter("sessionid") != null)) {
      this.b.k = new dr(getParameter("username"), getParameter("sessionid"));
      System.out.println("Setting user: " + this.b.k.b + ", " + this.b.k.c);
      if (getParameter("mppass") != null)
        this.b.k.d = getParameter("mppass");
    }
    else {
      this.b.k = new dr("Player", "");
    }

    if ((getParameter("server") != null) && (getParameter("port") != null)) {
      this.b.a(getParameter("server"), Integer.parseInt(getParameter("port")));
    }

    this.b.n = true;
    if ("true".equals(getParameter("stand-alone"))) this.b.n = false;
    setLayout(new BorderLayout());
    add(this.a, "Center");
    this.a.setFocusable(true);
    validate();
  }

  public void a() {
    if (this.c != null) return;
    this.c = new Thread(this.b, "Minecraft main thread");
    this.c.start();
  }

  public void start() {
    if (this.b != null) this.b.o = false; 
  }

  public void stop()
  {
    if (this.b != null) this.b.o = true; 
  }

  public void destroy()
  {
    b();
  }

  public void b() {
    if (this.c == null) return;
    this.b.f();
    try {
      this.c.join(10000L);
    } catch (InterruptedException localInterruptedException) {
      try {
        this.b.d();
      } catch (Exception localException) {
        localException.printStackTrace();
      }
    }
    this.c = null;
  }

  public void c() {
    this.a = null;
    this.b = null;
    this.c = null;
    try {
      removeAll();
      validate();
    }
    catch (Exception localException)
    {
    }
  }
  }
