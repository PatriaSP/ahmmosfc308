/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.sfc.app308.vo;

import java.io.OutputStream;

/**
 *
 * @author patria
 */
public class Sfc308VoOS extends OutputStream {
    protected StringBuffer buf = new StringBuffer();

    public void write(byte[] b)
    {
        String str = new String(b);
        this.buf.append(str);
    }

    public void write(byte[] b, int off, int len)
    {
        String str = new String(b, off, len);
        this.buf.append(str);
    }

    public void write(int b)
    {
        String str = Integer.toString(b);
        this.buf.append(str);
    }

    public String toString()
    {
        return this.buf.toString();
    }
}