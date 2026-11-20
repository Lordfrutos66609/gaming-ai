package com.lootwise.app;

import android.app.*;
import android.os.*;
import android.content.*;
import android.graphics.*;
import android.graphics.drawable.GradientDrawable;
import android.view.*;
import android.widget.*;
import android.text.InputType;
import android.util.Base64;
import org.json.*;
import java.io.*;
import java.util.concurrent.*;

public class MainActivity extends Activity {
 private final int BG=Color.rgb(11,16,26), CARD=Color.rgb(22,32,49), GOLD=Color.rgb(235,199,107), TEXT=Color.rgb(235,239,248), MUTED=Color.rgb(157,173,198);
 private LinearLayout root, body, messages; private EditText input; private TextView status; private ScrollView scroll;
 private SharedPreferences prefs; private KeyVault vault; private final ClaudeClient client=new ClaudeClient();
 private final ExecutorService worker=Executors.newSingleThreadExecutor(); private JSONArray history=new JSONArray();
 private boolean busy=false; private int generation=0; private String imageData=null, draft=""; private String tab="Coach";
 @Override public void onCreate(Bundle b){super.onCreate(b);prefs=getSharedPreferences("lootwise",0);vault=new KeyVault(this);
  try{history=new JSONArray(prefs.getString("history","[]"));}catch(Exception ignored){}
  if(b!=null)draft=b.getString("draft",""); render("Coach");}
 private int dp(int n){return (int)(n*getResources().getDisplayMetrics().density);}
 private GradientDrawable background(int color){GradientDrawable d=new GradientDrawable();d.setColor(color);d.setCornerRadius(dp(16));return d;}
 private TextView text(String value,int size,int color){TextView v=new TextView(this);v.setText(value);v.setTextSize(size);v.setTextColor(color);v.setPadding(dp(8),dp(6),dp(8),dp(6));return v;}
 private Button button(String label,Runnable action){Button b=new Button(this);b.setText(label);b.setTextColor(TEXT);b.setAllCaps(false);b.setOnClickListener(v->action.run());return b;}
 private EditText field(String hint,String value){EditText e=new EditText(this);e.setTextColor(TEXT);e.setHintTextColor(MUTED);e.setHint(hint);e.setText(value);e.setTextSize(16);e.setPadding(dp(12),dp(10),dp(12),dp(10));return e;}
 private void rememberDraft(){if(input!=null){draft=input.getText().toString();input=null;}}
 private void render(String next){rememberDraft();tab=next;root=new LinearLayout(this);root.setOrientation(1);root.setBackgroundColor(BG);root.setPadding(dp(16),dp(12),dp(16),dp(8));
  root.setOnApplyWindowInsetsListener((v,insets)->{v.setPadding(dp(16)+insets.getSystemWindowInsetLeft(),dp(12)+insets.getSystemWindowInsetTop(),dp(16)+insets.getSystemWindowInsetRight(),dp(8)+insets.getSystemWindowInsetBottom());return insets;});
  setContentView(root);root.addView(text("◆ LOOTWISE",26,GOLD));root.addView(text("Your game. Your build. Your next move.",13,MUTED));
  LinearLayout nav=new LinearLayout(this);for(String name:new String[]{"Coach","Hero","Settings"}){Button b=button(name,()->render(name));if(name.equals(next))b.setTextColor(GOLD);nav.addView(b,new LinearLayout.LayoutParams(0,dp(52),1));}root.addView(nav);
  body=new LinearLayout(this);body.setOrientation(1);root.addView(body,new LinearLayout.LayoutParams(-1,0,1));
  switch(next){case "Hero"->hero();case "Settings"->settings();default->coach();}}
 private void coach(){
  body.addView(text(prefs.getString("hero","Diablo II • Set up your Hero profile"),13,GOLD),new LinearLayout.LayoutParams(-1,dp(48)));
  scroll=new ScrollView(this);messages=new LinearLayout(this);messages.setOrientation(1);scroll.addView(messages);body.addView(scroll,new LinearLayout.LayoutParams(-1,0,1));
  if(history.length()==0){bubble("Lootwise","Welcome, adventurer. Add your API key in Settings, set your Hero profile, then ask about a build, item or strategy. I can also explain a screenshot.\n\nNo live game search in this version; check patch-sensitive advice.");
   for(String suggestion:new String[]{"Help me improve my build with cheap gear.","Teach me one Diablo II mechanic with a small exercise.","Help me decide where to farm next."}) messages.addView(button(suggestion,()->input.setText(suggestion)));}
  for(int i=0;i<history.length();i++){JSONObject m=history.optJSONObject(i);if(m!=null)bubble(m.optString("role").equals("user")?"You":"Lootwise",m.optString("content"));}
  status=text(busy?"Thinking…":imageData!=null?"Screenshot attached · sent with your next message":"Model advice · verify important game details",12,MUTED);body.addView(status);
  input=field("Ask your gaming coach…",draft);input.setEnabled(!busy);input.setMinLines(1);input.setMaxLines(4);input.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_MULTI_LINE|InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);body.addView(input);
  LinearLayout controls=new LinearLayout(this);controls.addView(button(imageData==null?"+ Image":"Remove image",()->{if(busy)return;if(imageData!=null){imageData=null;render("Coach");}else pickImage();}),new LinearLayout.LayoutParams(0,dp(52),1));
  controls.addView(button(busy?"Stop":"Send",()->{if(busy){generation++;busy=false;client.cancel();render("Coach");}else send();}),new LinearLayout.LayoutParams(0,dp(52),1));body.addView(controls);
  body.addView(button("New conversation",()->{if(busy){toast("Stop the current request first.");return;}new AlertDialog.Builder(this).setMessage("Clear this conversation on your phone?").setNegativeButton("Keep",null).setPositiveButton("Clear",(d,w)->{history=new JSONArray();saveHistory();imageData=null;draft="";if(input!=null)input.setText("");render("Coach");}).show();}));
  scroll.post(()->scroll.fullScroll(View.FOCUS_DOWN));
 }
 private void bubble(String who,String value){LinearLayout box=new LinearLayout(this);box.setOrientation(1);box.setPadding(dp(10),dp(8),dp(10),dp(12));box.setBackground(background(CARD));LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(-1,-2);lp.setMargins(0,dp(6),0,dp(6));messages.addView(box,lp);box.addView(text(who,12,GOLD));TextView content=text(value,16,TEXT);content.setTextIsSelectable(true);box.addView(content);}
 private void hero(){body.addView(text("Build your context",22,GOLD));body.addView(text("Include game and patch, offline or ladder, class, level, gear and your goal. Changing the profile starts a fresh conversation.",14,MUTED));EditText profile=field("e.g. Diablo II Resurrected, offline, Sorceress level 45…",prefs.getString("hero","Diablo II Resurrected • Offline\nClass / level:\nPatch / platform:\nSkills and gear:\nMy goal:"));profile.setGravity(Gravity.TOP);profile.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_MULTI_LINE);body.addView(profile,new LinearLayout.LayoutParams(-1,0,1));body.addView(button("Save hero",()->{if(busy){toast("Stop the current request first.");return;}String value=profile.getText().toString().trim();if(value.length()>6000){toast("Please keep the profile under 6,000 characters.");return;}prefs.edit().putString("hero",value).apply();history=new JSONArray();saveHistory();imageData=null;draft="";render("Coach");toast("Hero saved. New conversation ready.");}));}
 private void settings(){ScrollView sc=new ScrollView(this);LinearLayout form=new LinearLayout(this);form.setOrientation(1);sc.addView(form);body.addView(sc);form.addView(text("Connect your coach",22,GOLD));form.addView(text("Use your own Anthropic API key. API usage is paid separately from a Claude subscription. Your key stays encrypted on this device. Messages, your hero profile and attached images are sent to Anthropic when you press Send.",14,MUTED));
  EditText key=field("New API key (leave blank to keep saved key)","");key.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);key.setImportantForAutofill(View.IMPORTANT_FOR_AUTOFILL_NO);form.addView(key);
  EditText workspace=field("Workspace ID (optional)",prefs.getString("workspace",""));workspace.setSingleLine(true);form.addView(workspace);
  EditText model=field("Model ID — use Load models below",prefs.getString("model",""));model.setSingleLine(true);form.addView(model);
  form.addView(button("Save settings",()->{try{if(busy){toast("Stop the current request first.");return;}String k=key.getText().toString().trim();if(!k.isEmpty())vault.save(k);prefs.edit().putString("workspace",workspace.getText().toString().trim()).putString("model",model.getText().toString().trim()).apply();key.setText("");toast("Settings saved.");}catch(Exception e){toast("Could not save securely. Please try again.");}}));
  form.addView(button("Load available models",()->{if(busy){toast("A request is already running.");return;}try{String k=key.getText().toString().trim();if(k.isEmpty())k=vault.read();if(k.isEmpty()){toast("Enter an API key first.");return;}final String apiKey=k, ws=workspace.getText().toString().trim();busy=true;toast("Loading model names…");worker.execute(()->{try{JSONArray models=client.request("models?limit=100",apiKey,ws,null).getJSONArray("data");String[] labels=new String[models.length()],ids=new String[models.length()];for(int i=0;i<models.length();i++){JSONObject m=models.getJSONObject(i);ids[i]=m.getString("id");labels[i]=m.optString("display_name",ids[i])+"\n"+ids[i];}runOnUiThread(()->{busy=false;if(isFinishing())return;new AlertDialog.Builder(this).setTitle("Choose model · costs vary").setItems(labels,(d,w)->{model.setText(ids[w]);toast("Press Save settings to keep this model.");}).setNegativeButton("Cancel",null).show();});}catch(Exception e){runOnUiThread(()->{busy=false;toast(safeError(e));});}});}catch(Exception e){toast("Please save a new API key.");}}));
  form.addView(button("Get an API key",()->startActivity(new Intent(Intent.ACTION_VIEW,android.net.Uri.parse("https://platform.claude.com/settings/keys")))));
  form.addView(button("Remove saved API key",()->{if(busy){toast("Stop the request first.");return;}vault.clear();toast("Saved key removed.");}));
  form.addView(text("Lootwise 0.1 · Android test build\nLocal storage: hero profile and recent chat. No analytics. No web browsing. Screenshots are not saved by Lootwise. Clearing app storage removes local data. Friends need their own API key. Never paste passwords into chat.",13,MUTED));
 }
 private void send(){String question=input.getText().toString().trim();if(question.isEmpty()&&imageData==null)return;if(question.length()>8000){toast("Please keep your message under 8,000 characters.");return;}
  try{String key=vault.read(),model=prefs.getString("model","");if(key.isEmpty()||model.isEmpty()){toast("Add your API key and choose a model in Settings.");return;}
   if(question.isEmpty())question="Explain this gaming screenshot and suggest the next useful step.";
   final String q=question, picture=imageData;JSONArray outgoing=new JSONArray();for(int i=Math.max(0,history.length()-12);i<history.length();i++)outgoing.put(history.getJSONObject(i));
   JSONArray blocks=new JSONArray();blocks.put(new JSONObject().put("type","text").put("text",q));if(picture!=null)blocks.put(new JSONObject().put("type","image").put("source",new JSONObject().put("type","base64").put("media_type","image/jpeg").put("data",picture)));
   outgoing.put(new JSONObject().put("role","user").put("content",blocks));JSONObject payload=new JSONObject().put("model",model).put("max_tokens",1200).put("system",CoachRules.system(prefs.getString("hero","Not set"))).put("messages",outgoing);
   String ws=prefs.getString("workspace","");busy=true;final int token=++generation;render("Coach");worker.execute(()->{try{JSONObject response=client.request("messages",key,ws,payload);JSONArray content=response.getJSONArray("content");StringBuilder reply=new StringBuilder();for(int i=0;i<content.length();i++){JSONObject block=content.getJSONObject(i);if("text".equals(block.optString("type")))reply.append(block.optString("text")).append('\n');}if(reply.length()==0)throw new IOException("No text received from this model.");if("max_tokens".equals(response.optString("stop_reason")))reply.append("\n[Reply reached the length limit. Ask me to continue.]");String answer=reply.toString().trim();runOnUiThread(()->{if(token!=generation||isFinishing())return;busy=false;try{history.put(new JSONObject().put("role","user").put("content",q+(picture!=null?"\n[Image attached to this turn only]":"")));history.put(new JSONObject().put("role","assistant").put("content",answer));while(history.length()>24){history.remove(0);history.remove(0);}saveHistory();}catch(Exception ignored){}imageData=null;draft="";if(input!=null)input.setText("");render(tab);});}catch(Exception e){runOnUiThread(()->{if(token!=generation||isFinishing())return;busy=false;render(tab);new AlertDialog.Builder(this).setTitle("Message not completed").setMessage(safeError(e)+" Your draft is kept. Retrying may incur another API charge.").setPositiveButton("OK",null).show();});}});
  }catch(Exception e){toast("Could not prepare the request. Check Settings.");}}
 private String safeError(Exception e){if(e instanceof java.net.SocketTimeoutException)return "The request timed out.";if(e instanceof IOException&&e.getMessage()!=null&&e.getMessage().startsWith("Provider"))return e.getMessage();if(e instanceof IOException&&e.getMessage()!=null&&e.getMessage().startsWith("API access"))return e.getMessage();return "Could not reach the model. Check your connection, key, credits and model.";}
 private void saveHistory(){prefs.edit().putString("history",history.toString()).apply();}
 private void pickImage(){Intent intent=new Intent(Intent.ACTION_OPEN_DOCUMENT);intent.setType("image/*");intent.addCategory(Intent.CATEGORY_OPENABLE);startActivityForResult(intent,41);}
 @Override protected void onActivityResult(int request,int result,Intent data){super.onActivityResult(request,result,data);if(request!=41||result!=RESULT_OK||data==null||data.getData()==null)return;android.net.Uri uri=data.getData();toast("Preparing screenshot…");worker.execute(()->{try{BitmapFactory.Options options=new BitmapFactory.Options();options.inJustDecodeBounds=true;try(InputStream in=getContentResolver().openInputStream(uri)){BitmapFactory.decodeStream(in,null,options);}if(options.outWidth<=0||options.outHeight<=0)throw new IOException();options.inSampleSize=CoachRules.sampleSize(options.outWidth,options.outHeight);options.inJustDecodeBounds=false;Bitmap bitmap;try(InputStream in=getContentResolver().openInputStream(uri)){bitmap=BitmapFactory.decodeStream(in,null,options);}if(bitmap==null)throw new IOException();ByteArrayOutputStream out=new ByteArrayOutputStream();bitmap.compress(Bitmap.CompressFormat.JPEG,85,out);bitmap.recycle();String encoded=Base64.encodeToString(out.toByteArray(),Base64.NO_WRAP);runOnUiThread(()->{if(isFinishing())return;imageData=encoded;render(tab);});}catch(Exception|OutOfMemoryError e){runOnUiThread(()->toast("This image could not be opened. Try a smaller screenshot."));}});}
 private void toast(String s){Toast.makeText(this,s,Toast.LENGTH_LONG).show();}
 @Override protected void onSaveInstanceState(Bundle b){b.putString("draft",input!=null?input.getText().toString():draft);super.onSaveInstanceState(b);}
 @Override protected void onDestroy(){generation++;client.cancel();worker.shutdownNow();super.onDestroy();}
}
