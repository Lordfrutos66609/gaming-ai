package com.lootwise.app;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;
import android.util.Base64;
import java.security.KeyStore;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

final class KeyVault {
 private final Context context;
 KeyVault(Context c) { context = c; }
 private SecretKey key() throws Exception {
  KeyStore ks = KeyStore.getInstance("AndroidKeyStore"); ks.load(null);
  if (!ks.containsAlias("lootwise.api")) {
   KeyGenerator g = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");
   g.init(new KeyGenParameterSpec.Builder("lootwise.api", KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
    .setBlockModes(KeyProperties.BLOCK_MODE_GCM).setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE).build());
   g.generateKey();
  }
  return (SecretKey) ks.getKey("lootwise.api", null);
 }
 void save(String value) throws Exception {
  Cipher c = Cipher.getInstance("AES/GCM/NoPadding"); c.init(Cipher.ENCRYPT_MODE, key());
  String encrypted = Base64.encodeToString(c.getIV(), Base64.NO_WRAP) + ":" + Base64.encodeToString(c.doFinal(value.getBytes(java.nio.charset.StandardCharsets.UTF_8)), Base64.NO_WRAP);
  context.getSharedPreferences("vault",0).edit().putString("key",encrypted).apply();
 }
 String read() throws Exception {
  String raw=context.getSharedPreferences("vault",0).getString("key", "");
  if(raw.isEmpty()) return "";
  String[] parts=raw.split(":",2);
  Cipher c=Cipher.getInstance("AES/GCM/NoPadding"); c.init(Cipher.DECRYPT_MODE,key(),new GCMParameterSpec(128, Base64.decode(parts[0],Base64.NO_WRAP)));
  return new String(c.doFinal(Base64.decode(parts[1],Base64.NO_WRAP)),java.nio.charset.StandardCharsets.UTF_8);
 }
 void clear() { context.getSharedPreferences("vault",0).edit().clear().apply(); }
}
