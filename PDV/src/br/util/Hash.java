package br.util;

import java.io.*;
import java.security.*;

import br.pdv.model.Usuario;

/**
 *  Quick Hash tool.
 *  This can be used as a quick and easy way to generate a hashes of a string
 *
 *@author     alceumelo (based on jtaylor work in the StringMD5 Class) 
 *@created    May 7, 2013 (StringMD5 created at January 10, 2005)

 */
public class Hash {
	
		public static void main(String[] args) {
			String texto = "The quick brown fox jumps over the lazy dog";
			System.out.println("MD5   :  " + Hash.md5(texto) + "\n\n");
			System.out.println("SHA1  :  " + Hash.sha1(texto) + "\n\n");
			System.out.println("SHA256:  " + Hash.sha256(texto) + "\n\n");
			System.out.println("SHA384:  " + Hash.sha384(texto) + "\n\n");
			System.out.println("SHA512:  " + Hash.sha512(texto) + "\n\n");
		}
       
        /**
         *  Method used to convert byte array to string.
         *
         *@param  array  Byte Array you would like converted to string format
         *@return        String format of byte array
         */
        private static String hex(byte[] array)
        {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < array.length; ++i)
                {
                        sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).toUpperCase().substring(1, 3));
                }
                return sb.toString();
        }


        /**
         * Static method to generate an MD5 hash from a string
         * ... an string with 32 hexadecimal digits
         *@param  message  String or message that you would like an MD5 hash of.
         *@return          MD5 has value of string
         */
        public static String md5(String message)
        {
                if (message==null) { message=""; }
                try
                {
                        MessageDigest md = MessageDigest.getInstance("MD5");
                        return hex(md.digest(message.getBytes("CP1252"))).toLowerCase();
                } catch (NoSuchAlgorithmException e)
                {
                } catch (UnsupportedEncodingException e)
                {
                }
                return null;
        }

        /**
         * Static method to generate an SHA1 hash from a string
         * ... an string with 40 hexadecimal digits
         *@param  message  String or message that you would like an SHA1 hash of.
         *@return          SHA1 has value of string
         */
        public static String sha1(String message)
        {
                if (message==null) { message=""; }
                try
                {
                        MessageDigest md = MessageDigest.getInstance("SHA-1");
                        return hex(md.digest(message.getBytes("CP1252"))).toLowerCase();
                } catch (NoSuchAlgorithmException e)
                {
                } catch (UnsupportedEncodingException e)
                {
                }
                return null;
        }

        /**
         * Static method to generate an SHA256 hash from a string
         * ... an string with 64 hexadecimal digits
         *@param  message  String or message that you would like an SHA256 hash of.
         *@return          SHA256 has value of string
         */
        public static String sha256(String message)
        {
                if (message==null) { message=""; }
                try
                {
                        MessageDigest md = MessageDigest.getInstance("SHA-256");
                        return hex(md.digest(message.getBytes("CP1252"))).toLowerCase();
                } catch (NoSuchAlgorithmException e)
                {
                } catch (UnsupportedEncodingException e)
                {
                }
                return null;
        }

        /**
         * Static method to generate an SHA384 hash from a string
         * ... an string with 96 hexadecimal digits
         *@param  message  String or message that you would like an SHA384 hash of.
         *@return          SHA384 has value of string
         */
        public static String sha384(String message)
        {
                if (message==null) { message=""; }
                try
                {
                        MessageDigest md = MessageDigest.getInstance("SHA-384");
                        return hex(md.digest(message.getBytes("CP1252"))).toLowerCase();
                } catch (NoSuchAlgorithmException e)
                {
                } catch (UnsupportedEncodingException e)
                {
                }
                return null;
        }

        /**
         * Static method to generate an SHA512 hash from a string
         * ... an string with 128 hexadecimal digits
         *@param  message  String or message that you would like an SHA512 hash of.
         *@return          SHA512 has value of string
         */
        public static String sha512(String message)
        {
                if (message==null) { message=""; }
                try
                {
                        MessageDigest md = MessageDigest.getInstance("SHA-512");
                        return hex(md.digest(message.getBytes("CP1252"))).toLowerCase();
                } catch (NoSuchAlgorithmException e)
                {
                } catch (UnsupportedEncodingException e)
                {
                }
                return null;
        }

}