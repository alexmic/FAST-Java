
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The FAST12 corner detection algorithm. The code is a port from the Python code
 * found on FAST's website at http://mi.eng.cam.ac.uk/~er258/work/fast.html.
 * 
 * @author Alexandros Michael 2011.
 *
 */
public class Fast12 {
	
	/**
	 * Detect FAST corners by applying a non-maximum suppression algorithm on the results,
	 * to allow only maximal corners.
	 * 
	 * @param image A two-dimensional integer array representing the intensities of the
	 * 				pixels in the image. The image is assumed to be grayscale.
	 * @param w The width of the image.
	 * @param h The height of the image.
	 * @param threshold A number denoting how much brighter or darker the pixels 
	 * 				    surrounding the pixel in question should be in order to
	 * 					be considered a corner.
	 * @param N	The number of corners to return. To return all corners just 
	 * 			use N=-1.
	 * 
	 * @return A list of FeaturePoint objects. Each object wraps an (x,y,score) tuple.
	 */
	public static List<FeaturePoint> detectWithNonMax(int[][] image, int w, int h, int threshold, int N) 
	{
		List<FeaturePoint> features = detect(image, w, h, threshold, -1);
		features = nonMaxSuppression(w, h, features);
		int count = features.size();
		if (N == -1)
			return features;
		else
			return features.subList(0, (count > N)? N : count);
	}
	
	/**
	 * Detect FAST corners WITHOUT applying a non-maximum suppression algorithm on the results.
	 * As Ed Rosten states,"non-maximal corners tend to provide little or no extra information 
	 * and tend to be less stable".
	 * 
	 * @param image A two-dimensional integer array representing the intensities of the
	 * 				pixels in the image. The image is assumed to be grayscale.
	 * @param w The width of the image.
	 * @param h The height of the image.
	 * @param threshold A number denoting how much brighter or darker the pixels 
	 * 				    surrounding the pixel in question should be in order to
	 * 					pass the detector's test.
	 * @param N	The number of corners to return. To return all corners just 
	 * 			use N=-1.
	 * 
	 * @return A list of FeaturePoint objects. Each object wraps an (x,y,score) tuple.
	 */
	public static List<FeaturePoint> detect(int[][] image, int w, int h, int threshold, int N)
	{
		ArrayList<FeaturePoint> corners = new ArrayList<FeaturePoint>();
		int count = 0;
		
		for (int y = 4; y < h - 4; ++y) {
			for (int x = 4; x < w - 4; ++x) {
				int cb = image[y][x] + threshold;
				int c_b = image[y][x] - threshold;
				if (image[y+3][x+0] > cb) 
				 if (image[y+3][x+1] > cb) 
				  if (image[y+2][x+2] > cb) 
				   if (image[y+1][x+3] > cb) 
				    if (image[y+0][x+3] > cb) 
				     if (image[y+-1][x+3] > cb) 
				      if (image[y+-2][x+2] > cb) 
				       if (image[y+-3][x+1] > cb) 
				        if (image[y+-3][x+0] > cb) 
				         if (image[y+-3][x+-1] > cb) 
				          if (image[y+-2][x+-2] > cb) 
				           if (image[y+-1][x+-3] > cb) 
				            {;}
				           else
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             continue;
				          else
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             continue;
				           else
				            continue;
				         else
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				        else
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				       else
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				      else
				       if (image[y+-2][x+-2] > cb) 
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				     else
				      if (image[y+-3][x+-1] > cb) 
				       if (image[y+-2][x+-2] > cb) 
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				    else if (image[y+0][x+3] < c_b) 
				     if (image[y+-3][x+0] > cb) 
				      if (image[y+-3][x+-1] > cb) 
				       if (image[y+-2][x+-2] > cb) 
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else if (image[y+-3][x+0] < c_b) 
				      if (image[y+-1][x+3] < c_b)
				       if (image[y+-2][x+2] < c_b)
				        if (image[y+-3][x+1] < c_b)
				         if (image[y+-3][x+-1] < c_b)
				          if (image[y+-2][x+-2] < c_b)
				           if (image[y+-1][x+-3] < c_b)
				            if (image[y+0][x+-3] < c_b)
				             if (image[y+1][x+-3] < c_b)
				              if (image[y+2][x+-2] < c_b)
				               if (image[y+3][x+-1] < c_b)
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     if (image[y+-3][x+0] > cb) 
				      if (image[y+-3][x+-1] > cb) 
				       if (image[y+-2][x+-2] > cb) 
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				   else if (image[y+1][x+3] < c_b) 
				    if (image[y+3][x+-1] > cb) 
				     if (image[y+-3][x+1] > cb) 
				      if (image[y+-3][x+0] > cb) 
				       if (image[y+-3][x+-1] > cb) 
				        if (image[y+-2][x+-2] > cb) 
				         if (image[y+-1][x+-3] > cb) 
				          if (image[y+0][x+-3] > cb) 
				           if (image[y+1][x+-3] > cb) 
				            if (image[y+2][x+-2] > cb) 
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else if (image[y+-3][x+1] < c_b) 
				      if (image[y+0][x+3] < c_b)
				       if (image[y+-1][x+3] < c_b)
				        if (image[y+-2][x+2] < c_b)
				         if (image[y+-3][x+0] < c_b)
				          if (image[y+-3][x+-1] < c_b)
				           if (image[y+-2][x+-2] < c_b)
				            if (image[y+-1][x+-3] < c_b)
				             if (image[y+0][x+-3] < c_b)
				              if (image[y+1][x+-3] < c_b)
				               if (image[y+2][x+-2] < c_b)
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     if (image[y+0][x+3] < c_b)
				      if (image[y+-1][x+3] < c_b)
				       if (image[y+-2][x+2] < c_b)
				        if (image[y+-3][x+1] < c_b)
				         if (image[y+-3][x+0] < c_b)
				          if (image[y+-3][x+-1] < c_b)
				           if (image[y+-2][x+-2] < c_b)
				            if (image[y+-1][x+-3] < c_b)
				             if (image[y+0][x+-3] < c_b)
				              if (image[y+1][x+-3] < c_b)
				               if (image[y+2][x+-2] < c_b)
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				   else
				    if (image[y+-3][x+1] > cb) 
				     if (image[y+-3][x+0] > cb) 
				      if (image[y+-3][x+-1] > cb) 
				       if (image[y+-2][x+-2] > cb) 
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else if (image[y+-3][x+1] < c_b) 
				     if (image[y+0][x+3] < c_b)
				      if (image[y+-1][x+3] < c_b)
				       if (image[y+-2][x+2] < c_b)
				        if (image[y+-3][x+0] < c_b)
				         if (image[y+-3][x+-1] < c_b)
				          if (image[y+-2][x+-2] < c_b)
				           if (image[y+-1][x+-3] < c_b)
				            if (image[y+0][x+-3] < c_b)
				             if (image[y+1][x+-3] < c_b)
				              if (image[y+2][x+-2] < c_b)
				               if (image[y+3][x+-1] < c_b)
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				  else if (image[y+2][x+2] < c_b) 
				   if (image[y+-2][x+2] > cb) 
				    if (image[y+-3][x+1] > cb) 
				     if (image[y+-3][x+0] > cb) 
				      if (image[y+-3][x+-1] > cb) 
				       if (image[y+-2][x+-2] > cb) 
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             if (image[y+1][x+3] > cb) 
				              if (image[y+0][x+3] > cb) 
				               if (image[y+-1][x+3] > cb) 
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else if (image[y+-2][x+2] < c_b) 
				    if (image[y+0][x+3] < c_b)
				     if (image[y+-1][x+3] < c_b)
				      if (image[y+-3][x+1] < c_b)
				       if (image[y+-3][x+0] < c_b)
				        if (image[y+-3][x+-1] < c_b)
				         if (image[y+-2][x+-2] < c_b)
				          if (image[y+-1][x+-3] < c_b)
				           if (image[y+0][x+-3] < c_b)
				            if (image[y+1][x+-3] < c_b)
				             if (image[y+1][x+3] < c_b)
				              {;}
				             else
				              if (image[y+2][x+-2] < c_b)
				               if (image[y+3][x+-1] < c_b)
				                {;}
				               else
				                continue;
				              else
				               continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else
				   if (image[y+-2][x+2] > cb) 
				    if (image[y+-3][x+1] > cb) 
				     if (image[y+-3][x+0] > cb) 
				      if (image[y+-3][x+-1] > cb) 
				       if (image[y+-2][x+-2] > cb) 
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             if (image[y+1][x+3] > cb) 
				              if (image[y+0][x+3] > cb) 
				               if (image[y+-1][x+3] > cb) 
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else if (image[y+-2][x+2] < c_b) 
				    if (image[y+0][x+3] < c_b)
				     if (image[y+-1][x+3] < c_b)
				      if (image[y+-3][x+1] < c_b)
				       if (image[y+-3][x+0] < c_b)
				        if (image[y+-3][x+-1] < c_b)
				         if (image[y+-2][x+-2] < c_b)
				          if (image[y+-1][x+-3] < c_b)
				           if (image[y+0][x+-3] < c_b)
				            if (image[y+1][x+-3] < c_b)
				             if (image[y+2][x+-2] < c_b)
				              if (image[y+1][x+3] < c_b)
				               {;}
				              else
				               if (image[y+3][x+-1] < c_b)
				                {;}
				               else
				                continue;
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				 else if (image[y+3][x+1] < c_b) 
				  if (image[y+-1][x+3] > cb) 
				   if (image[y+-2][x+2] > cb) 
				    if (image[y+-3][x+1] > cb) 
				     if (image[y+-3][x+0] > cb) 
				      if (image[y+-3][x+-1] > cb) 
				       if (image[y+-2][x+-2] > cb) 
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             if (image[y+1][x+3] > cb) 
				              if (image[y+0][x+3] > cb) 
				               {;}
				              else
				               continue;
				             else
				              continue;
				           else
				            if (image[y+2][x+2] > cb) 
				             if (image[y+1][x+3] > cb) 
				              if (image[y+0][x+3] > cb) 
				               {;}
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else if (image[y+-1][x+3] < c_b) 
				   if (image[y+0][x+3] < c_b)
				    if (image[y+-2][x+2] < c_b)
				     if (image[y+-3][x+1] < c_b)
				      if (image[y+-3][x+0] < c_b)
				       if (image[y+-3][x+-1] < c_b)
				        if (image[y+-2][x+-2] < c_b)
				         if (image[y+-1][x+-3] < c_b)
				          if (image[y+0][x+-3] < c_b)
				           if (image[y+1][x+3] < c_b)
				            if (image[y+2][x+2] < c_b)
				             {;}
				            else
				             if (image[y+1][x+-3] < c_b)
				              if (image[y+2][x+-2] < c_b)
				               {;}
				              else
				               continue;
				             else
				              continue;
				           else
				            if (image[y+1][x+-3] < c_b)
				             if (image[y+2][x+-2] < c_b)
				              if (image[y+3][x+-1] < c_b)
				               {;}
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else
				   continue;
				 else
				  if (image[y+-1][x+3] > cb) 
				   if (image[y+-2][x+2] > cb) 
				    if (image[y+-3][x+1] > cb) 
				     if (image[y+-3][x+0] > cb) 
				      if (image[y+-3][x+-1] > cb) 
				       if (image[y+-2][x+-2] > cb) 
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             if (image[y+1][x+3] > cb) 
				              if (image[y+0][x+3] > cb) 
				               {;}
				              else
				               continue;
				             else
				              continue;
				           else
				            if (image[y+2][x+2] > cb) 
				             if (image[y+1][x+3] > cb) 
				              if (image[y+0][x+3] > cb) 
				               {;}
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else if (image[y+-1][x+3] < c_b) 
				   if (image[y+0][x+3] < c_b)
				    if (image[y+-2][x+2] < c_b)
				     if (image[y+-3][x+1] < c_b)
				      if (image[y+-3][x+0] < c_b)
				       if (image[y+-3][x+-1] < c_b)
				        if (image[y+-2][x+-2] < c_b)
				         if (image[y+-1][x+-3] < c_b)
				          if (image[y+0][x+-3] < c_b)
				           if (image[y+1][x+-3] < c_b)
				            if (image[y+1][x+3] < c_b)
				             if (image[y+2][x+2] < c_b)
				              {;}
				             else
				              if (image[y+2][x+-2] < c_b)
				               {;}
				              else
				               continue;
				            else
				             if (image[y+2][x+-2] < c_b)
				              if (image[y+3][x+-1] < c_b)
				               {;}
				              else
				               continue;
				             else
				              continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else
				   continue;
				else if (image[y+3][x+0] < c_b) 
				 if (image[y+3][x+1] > cb) 
				  if (image[y+-1][x+3] > cb) 
				   if (image[y+0][x+3] > cb) 
				    if (image[y+-2][x+2] > cb) 
				     if (image[y+-3][x+1] > cb) 
				      if (image[y+-3][x+0] > cb) 
				       if (image[y+-3][x+-1] > cb) 
				        if (image[y+-2][x+-2] > cb) 
				         if (image[y+-1][x+-3] > cb) 
				          if (image[y+0][x+-3] > cb) 
				           if (image[y+1][x+3] > cb) 
				            if (image[y+2][x+2] > cb) 
				             {;}
				            else
				             if (image[y+1][x+-3] > cb) 
				              if (image[y+2][x+-2] > cb) 
				               {;}
				              else
				               continue;
				             else
				              continue;
				           else
				            if (image[y+1][x+-3] > cb) 
				             if (image[y+2][x+-2] > cb) 
				              if (image[y+3][x+-1] > cb) 
				               {;}
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else if (image[y+-1][x+3] < c_b) 
				   if (image[y+-2][x+2] < c_b)
				    if (image[y+-3][x+1] < c_b)
				     if (image[y+-3][x+0] < c_b)
				      if (image[y+-3][x+-1] < c_b)
				       if (image[y+-2][x+-2] < c_b)
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             if (image[y+1][x+3] < c_b)
				              if (image[y+0][x+3] < c_b)
				               {;}
				              else
				               continue;
				             else
				              continue;
				           else
				            if (image[y+2][x+2] < c_b)
				             if (image[y+1][x+3] < c_b)
				              if (image[y+0][x+3] < c_b)
				               {;}
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else
				   continue;
				 else if (image[y+3][x+1] < c_b) 
				  if (image[y+2][x+2] > cb) 
				   if (image[y+-2][x+2] > cb) 
				    if (image[y+0][x+3] > cb) 
				     if (image[y+-1][x+3] > cb) 
				      if (image[y+-3][x+1] > cb) 
				       if (image[y+-3][x+0] > cb) 
				        if (image[y+-3][x+-1] > cb) 
				         if (image[y+-2][x+-2] > cb) 
				          if (image[y+-1][x+-3] > cb) 
				           if (image[y+0][x+-3] > cb) 
				            if (image[y+1][x+-3] > cb) 
				             if (image[y+1][x+3] > cb) 
				              {;}
				             else
				              if (image[y+2][x+-2] > cb) 
				               if (image[y+3][x+-1] > cb) 
				                {;}
				               else
				                continue;
				              else
				               continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else if (image[y+-2][x+2] < c_b) 
				    if (image[y+-3][x+1] < c_b)
				     if (image[y+-3][x+0] < c_b)
				      if (image[y+-3][x+-1] < c_b)
				       if (image[y+-2][x+-2] < c_b)
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             if (image[y+1][x+3] < c_b)
				              if (image[y+0][x+3] < c_b)
				               if (image[y+-1][x+3] < c_b)
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else if (image[y+2][x+2] < c_b) 
				   if (image[y+1][x+3] > cb) 
				    if (image[y+3][x+-1] < c_b)
				     if (image[y+-3][x+1] > cb) 
				      if (image[y+0][x+3] > cb) 
				       if (image[y+-1][x+3] > cb) 
				        if (image[y+-2][x+2] > cb) 
				         if (image[y+-3][x+0] > cb) 
				          if (image[y+-3][x+-1] > cb) 
				           if (image[y+-2][x+-2] > cb) 
				            if (image[y+-1][x+-3] > cb) 
				             if (image[y+0][x+-3] > cb) 
				              if (image[y+1][x+-3] > cb) 
				               if (image[y+2][x+-2] > cb) 
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else if (image[y+-3][x+1] < c_b) 
				      if (image[y+-3][x+0] < c_b)
				       if (image[y+-3][x+-1] < c_b)
				        if (image[y+-2][x+-2] < c_b)
				         if (image[y+-1][x+-3] < c_b)
				          if (image[y+0][x+-3] < c_b)
				           if (image[y+1][x+-3] < c_b)
				            if (image[y+2][x+-2] < c_b)
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     if (image[y+0][x+3] > cb) 
				      if (image[y+-1][x+3] > cb) 
				       if (image[y+-2][x+2] > cb) 
				        if (image[y+-3][x+1] > cb) 
				         if (image[y+-3][x+0] > cb) 
				          if (image[y+-3][x+-1] > cb) 
				           if (image[y+-2][x+-2] > cb) 
				            if (image[y+-1][x+-3] > cb) 
				             if (image[y+0][x+-3] > cb) 
				              if (image[y+1][x+-3] > cb) 
				               if (image[y+2][x+-2] > cb) 
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				   else if (image[y+1][x+3] < c_b) 
				    if (image[y+0][x+3] > cb) 
				     if (image[y+-3][x+0] > cb) 
				      if (image[y+-1][x+3] > cb) 
				       if (image[y+-2][x+2] > cb) 
				        if (image[y+-3][x+1] > cb) 
				         if (image[y+-3][x+-1] > cb) 
				          if (image[y+-2][x+-2] > cb) 
				           if (image[y+-1][x+-3] > cb) 
				            if (image[y+0][x+-3] > cb) 
				             if (image[y+1][x+-3] > cb) 
				              if (image[y+2][x+-2] > cb) 
				               if (image[y+3][x+-1] > cb) 
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else if (image[y+-3][x+0] < c_b) 
				      if (image[y+-3][x+-1] < c_b)
				       if (image[y+-2][x+-2] < c_b)
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else if (image[y+0][x+3] < c_b) 
				     if (image[y+-1][x+3] < c_b)
				      if (image[y+-2][x+2] < c_b)
				       if (image[y+-3][x+1] < c_b)
				        if (image[y+-3][x+0] < c_b)
				         if (image[y+-3][x+-1] < c_b)
				          if (image[y+-2][x+-2] < c_b)
				           if (image[y+-1][x+-3] < c_b)
				            {;}
				           else
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             continue;
				          else
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             continue;
				           else
				            continue;
				         else
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				        else
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				       else
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				      else
				       if (image[y+-2][x+-2] < c_b)
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				     else
				      if (image[y+-3][x+-1] < c_b)
				       if (image[y+-2][x+-2] < c_b)
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				    else
				     if (image[y+-3][x+0] < c_b)
				      if (image[y+-3][x+-1] < c_b)
				       if (image[y+-2][x+-2] < c_b)
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				   else
				    if (image[y+-3][x+1] > cb) 
				     if (image[y+0][x+3] > cb) 
				      if (image[y+-1][x+3] > cb) 
				       if (image[y+-2][x+2] > cb) 
				        if (image[y+-3][x+0] > cb) 
				         if (image[y+-3][x+-1] > cb) 
				          if (image[y+-2][x+-2] > cb) 
				           if (image[y+-1][x+-3] > cb) 
				            if (image[y+0][x+-3] > cb) 
				             if (image[y+1][x+-3] > cb) 
				              if (image[y+2][x+-2] > cb) 
				               if (image[y+3][x+-1] > cb) 
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else if (image[y+-3][x+1] < c_b) 
				     if (image[y+-3][x+0] < c_b)
				      if (image[y+-3][x+-1] < c_b)
				       if (image[y+-2][x+-2] < c_b)
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				  else
				   if (image[y+-2][x+2] > cb) 
				    if (image[y+0][x+3] > cb) 
				     if (image[y+-1][x+3] > cb) 
				      if (image[y+-3][x+1] > cb) 
				       if (image[y+-3][x+0] > cb) 
				        if (image[y+-3][x+-1] > cb) 
				         if (image[y+-2][x+-2] > cb) 
				          if (image[y+-1][x+-3] > cb) 
				           if (image[y+0][x+-3] > cb) 
				            if (image[y+1][x+-3] > cb) 
				             if (image[y+2][x+-2] > cb) 
				              if (image[y+1][x+3] > cb) 
				               {;}
				              else
				               if (image[y+3][x+-1] > cb) 
				                {;}
				               else
				                continue;
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else if (image[y+-2][x+2] < c_b) 
				    if (image[y+-3][x+1] < c_b)
				     if (image[y+-3][x+0] < c_b)
				      if (image[y+-3][x+-1] < c_b)
				       if (image[y+-2][x+-2] < c_b)
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             if (image[y+1][x+3] < c_b)
				              if (image[y+0][x+3] < c_b)
				               if (image[y+-1][x+3] < c_b)
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				 else
				  if (image[y+-1][x+3] > cb) 
				   if (image[y+0][x+3] > cb) 
				    if (image[y+-2][x+2] > cb) 
				     if (image[y+-3][x+1] > cb) 
				      if (image[y+-3][x+0] > cb) 
				       if (image[y+-3][x+-1] > cb) 
				        if (image[y+-2][x+-2] > cb) 
				         if (image[y+-1][x+-3] > cb) 
				          if (image[y+0][x+-3] > cb) 
				           if (image[y+1][x+-3] > cb) 
				            if (image[y+1][x+3] > cb) 
				             if (image[y+2][x+2] > cb) 
				              {;}
				             else
				              if (image[y+2][x+-2] > cb) 
				               {;}
				              else
				               continue;
				            else
				             if (image[y+2][x+-2] > cb) 
				              if (image[y+3][x+-1] > cb) 
				               {;}
				              else
				               continue;
				             else
				              continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else if (image[y+-1][x+3] < c_b) 
				   if (image[y+-2][x+2] < c_b)
				    if (image[y+-3][x+1] < c_b)
				     if (image[y+-3][x+0] < c_b)
				      if (image[y+-3][x+-1] < c_b)
				       if (image[y+-2][x+-2] < c_b)
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             if (image[y+1][x+3] < c_b)
				              if (image[y+0][x+3] < c_b)
				               {;}
				              else
				               continue;
				             else
				              continue;
				           else
				            if (image[y+2][x+2] < c_b)
				             if (image[y+1][x+3] < c_b)
				              if (image[y+0][x+3] < c_b)
				               {;}
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else
				   continue;
				else
				 if (image[y+0][x+3] > cb) 
				  if (image[y+-1][x+3] > cb) 
				   if (image[y+-2][x+2] > cb) 
				    if (image[y+-3][x+1] > cb) 
				     if (image[y+-3][x+0] > cb) 
				      if (image[y+-3][x+-1] > cb) 
				       if (image[y+-2][x+-2] > cb) 
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+3] > cb) 
				           if (image[y+2][x+2] > cb) 
				            if (image[y+3][x+1] > cb) 
				             {;}
				            else
				             if (image[y+1][x+-3] > cb) 
				              {;}
				             else
				              continue;
				           else
				            if (image[y+1][x+-3] > cb) 
				             if (image[y+2][x+-2] > cb) 
				              {;}
				             else
				              continue;
				            else
				             continue;
				          else
				           if (image[y+1][x+-3] > cb) 
				            if (image[y+2][x+-2] > cb) 
				             if (image[y+3][x+-1] > cb) 
				              {;}
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else
				   continue;
				 else if (image[y+0][x+3] < c_b) 
				  if (image[y+-1][x+3] < c_b)
				   if (image[y+-2][x+2] < c_b)
				    if (image[y+-3][x+1] < c_b)
				     if (image[y+-3][x+0] < c_b)
				      if (image[y+-3][x+-1] < c_b)
				       if (image[y+-2][x+-2] < c_b)
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+3] < c_b)
				           if (image[y+2][x+2] < c_b)
				            if (image[y+3][x+1] < c_b)
				             {;}
				            else
				             if (image[y+1][x+-3] < c_b)
				              {;}
				             else
				              continue;
				           else
				            if (image[y+1][x+-3] < c_b)
				             if (image[y+2][x+-2] < c_b)
				              {;}
				             else
				              continue;
				            else
				             continue;
				          else
				           if (image[y+1][x+-3] < c_b)
				            if (image[y+2][x+-2] < c_b)
				             if (image[y+3][x+-1] < c_b)
				              {;}
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else
				   continue;
				 else
				  continue;
				corners.add(new FeaturePoint(x, y));
				count++;
			}
		}
		for (int i = 0; i < count; ++i) {
			int x = corners.get(i).x();
			int y = corners.get(i).y();
			corners.get(i).score(cornerScore(image, x, y));
		}
		Collections.sort(corners, Collections.reverseOrder());
		if (N == -1)
			return corners;
		else 
			return corners.subList(0, (N < count)? N : count);
	}
	
	/**
	 * Calculates a score for a corner, using binary search.
	 * 
	 * @param image A two dimensional integer array containing the image intensity values.
	 * @param posx The x-coordinate of the corner.
	 * @param posy The y-coordinate of the corner.
	 * @return Returns an integer representing the corner score.
	 */
	private static int cornerScore(int[][] image, int posx, int posy)
	{
		int bmin = 0;
		int bmax = 255;
		int b = (bmax + bmin)/2;
	    
		while (true)
		{
			if (isCorner(image, posx, posy, b)) {
				bmin = b;
			} else {
				bmax = b;
			}
	        
			if (bmin == bmax - 1 || bmin == bmax) {
				return bmin;
			}

			b = (bmin + bmax) / 2;
		}
	}
	
	/**
	 * Checks whether a (x,y) point is a corner.
	 * 
	 * @param image A two-dimensional integer array representing the intensities of the
	 * 				pixels in the image.
	 * @param posx The x-coordinate of the point.
	 * @param posy The y-coordinate of the point.
	 * @param threshold A number denoting how much brighter or darker the pixels 
	 * 				    surrounding the point in question should be in order to
	 * 					be considered a corner.
	 * @return
	 */
	private static boolean isCorner(int[][] image, int posx, int posy, int threshold)
	{		
		int cb = image[posy][posx] + threshold;
		int c_b = image[posy][posx] - threshold;
		if (image[posy+3][posx+0] > cb) 
		 if (image[posy+3][posx+1] > cb) 
		  if (image[posy+2][posx+2] > cb) 
		   if (image[posy+1][posx+3] > cb) 
		    if (image[posy+0][posx+3] > cb) 
		     if (image[posy+-1][posx+3] > cb) 
		      if (image[posy+-2][posx+2] > cb) 
		       if (image[posy+-3][posx+1] > cb) 
		        if (image[posy+-3][posx+0] > cb) 
		         if (image[posy+-3][posx+-1] > cb) 
		          if (image[posy+-2][posx+-2] > cb) 
		           if (image[posy+-1][posx+-3] > cb) 
		            return true;
		           else
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             return false;
		          else
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             return false;
		           else
		            return false;
		         else
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		        else
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		       else
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		      else
		       if (image[posy+-2][posx+-2] > cb) 
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		     else
		      if (image[posy+-3][posx+-1] > cb) 
		       if (image[posy+-2][posx+-2] > cb) 
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		    else if (image[posy+0][posx+3] < c_b) 
		     if (image[posy+-3][posx+0] > cb) 
		      if (image[posy+-3][posx+-1] > cb) 
		       if (image[posy+-2][posx+-2] > cb) 
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else if (image[posy+-3][posx+0] < c_b) 
		      if (image[posy+-1][posx+3] < c_b)
		       if (image[posy+-2][posx+2] < c_b)
		        if (image[posy+-3][posx+1] < c_b)
		         if (image[posy+-3][posx+-1] < c_b)
		          if (image[posy+-2][posx+-2] < c_b)
		           if (image[posy+-1][posx+-3] < c_b)
		            if (image[posy+0][posx+-3] < c_b)
		             if (image[posy+1][posx+-3] < c_b)
		              if (image[posy+2][posx+-2] < c_b)
		               if (image[posy+3][posx+-1] < c_b)
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     if (image[posy+-3][posx+0] > cb) 
		      if (image[posy+-3][posx+-1] > cb) 
		       if (image[posy+-2][posx+-2] > cb) 
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		   else if (image[posy+1][posx+3] < c_b) 
		    if (image[posy+3][posx+-1] > cb) 
		     if (image[posy+-3][posx+1] > cb) 
		      if (image[posy+-3][posx+0] > cb) 
		       if (image[posy+-3][posx+-1] > cb) 
		        if (image[posy+-2][posx+-2] > cb) 
		         if (image[posy+-1][posx+-3] > cb) 
		          if (image[posy+0][posx+-3] > cb) 
		           if (image[posy+1][posx+-3] > cb) 
		            if (image[posy+2][posx+-2] > cb) 
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else if (image[posy+-3][posx+1] < c_b) 
		      if (image[posy+0][posx+3] < c_b)
		       if (image[posy+-1][posx+3] < c_b)
		        if (image[posy+-2][posx+2] < c_b)
		         if (image[posy+-3][posx+0] < c_b)
		          if (image[posy+-3][posx+-1] < c_b)
		           if (image[posy+-2][posx+-2] < c_b)
		            if (image[posy+-1][posx+-3] < c_b)
		             if (image[posy+0][posx+-3] < c_b)
		              if (image[posy+1][posx+-3] < c_b)
		               if (image[posy+2][posx+-2] < c_b)
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     if (image[posy+0][posx+3] < c_b)
		      if (image[posy+-1][posx+3] < c_b)
		       if (image[posy+-2][posx+2] < c_b)
		        if (image[posy+-3][posx+1] < c_b)
		         if (image[posy+-3][posx+0] < c_b)
		          if (image[posy+-3][posx+-1] < c_b)
		           if (image[posy+-2][posx+-2] < c_b)
		            if (image[posy+-1][posx+-3] < c_b)
		             if (image[posy+0][posx+-3] < c_b)
		              if (image[posy+1][posx+-3] < c_b)
		               if (image[posy+2][posx+-2] < c_b)
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		   else
		    if (image[posy+-3][posx+1] > cb) 
		     if (image[posy+-3][posx+0] > cb) 
		      if (image[posy+-3][posx+-1] > cb) 
		       if (image[posy+-2][posx+-2] > cb) 
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else if (image[posy+-3][posx+1] < c_b) 
		     if (image[posy+0][posx+3] < c_b)
		      if (image[posy+-1][posx+3] < c_b)
		       if (image[posy+-2][posx+2] < c_b)
		        if (image[posy+-3][posx+0] < c_b)
		         if (image[posy+-3][posx+-1] < c_b)
		          if (image[posy+-2][posx+-2] < c_b)
		           if (image[posy+-1][posx+-3] < c_b)
		            if (image[posy+0][posx+-3] < c_b)
		             if (image[posy+1][posx+-3] < c_b)
		              if (image[posy+2][posx+-2] < c_b)
		               if (image[posy+3][posx+-1] < c_b)
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		  else if (image[posy+2][posx+2] < c_b) 
		   if (image[posy+-2][posx+2] > cb) 
		    if (image[posy+-3][posx+1] > cb) 
		     if (image[posy+-3][posx+0] > cb) 
		      if (image[posy+-3][posx+-1] > cb) 
		       if (image[posy+-2][posx+-2] > cb) 
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             if (image[posy+1][posx+3] > cb) 
		              if (image[posy+0][posx+3] > cb) 
		               if (image[posy+-1][posx+3] > cb) 
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else if (image[posy+-2][posx+2] < c_b) 
		    if (image[posy+0][posx+3] < c_b)
		     if (image[posy+-1][posx+3] < c_b)
		      if (image[posy+-3][posx+1] < c_b)
		       if (image[posy+-3][posx+0] < c_b)
		        if (image[posy+-3][posx+-1] < c_b)
		         if (image[posy+-2][posx+-2] < c_b)
		          if (image[posy+-1][posx+-3] < c_b)
		           if (image[posy+0][posx+-3] < c_b)
		            if (image[posy+1][posx+-3] < c_b)
		             if (image[posy+1][posx+3] < c_b)
		              return true;
		             else
		              if (image[posy+2][posx+-2] < c_b)
		               if (image[posy+3][posx+-1] < c_b)
		                return true;
		               else
		                return false;
		              else
		               return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else
		   if (image[posy+-2][posx+2] > cb) 
		    if (image[posy+-3][posx+1] > cb) 
		     if (image[posy+-3][posx+0] > cb) 
		      if (image[posy+-3][posx+-1] > cb) 
		       if (image[posy+-2][posx+-2] > cb) 
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             if (image[posy+1][posx+3] > cb) 
		              if (image[posy+0][posx+3] > cb) 
		               if (image[posy+-1][posx+3] > cb) 
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else if (image[posy+-2][posx+2] < c_b) 
		    if (image[posy+0][posx+3] < c_b)
		     if (image[posy+-1][posx+3] < c_b)
		      if (image[posy+-3][posx+1] < c_b)
		       if (image[posy+-3][posx+0] < c_b)
		        if (image[posy+-3][posx+-1] < c_b)
		         if (image[posy+-2][posx+-2] < c_b)
		          if (image[posy+-1][posx+-3] < c_b)
		           if (image[posy+0][posx+-3] < c_b)
		            if (image[posy+1][posx+-3] < c_b)
		             if (image[posy+2][posx+-2] < c_b)
		              if (image[posy+1][posx+3] < c_b)
		               return true;
		              else
		               if (image[posy+3][posx+-1] < c_b)
		                return true;
		               else
		                return false;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		 else if (image[posy+3][posx+1] < c_b) 
		  if (image[posy+-1][posx+3] > cb) 
		   if (image[posy+-2][posx+2] > cb) 
		    if (image[posy+-3][posx+1] > cb) 
		     if (image[posy+-3][posx+0] > cb) 
		      if (image[posy+-3][posx+-1] > cb) 
		       if (image[posy+-2][posx+-2] > cb) 
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             if (image[posy+1][posx+3] > cb) 
		              if (image[posy+0][posx+3] > cb) 
		               return true;
		              else
		               return false;
		             else
		              return false;
		           else
		            if (image[posy+2][posx+2] > cb) 
		             if (image[posy+1][posx+3] > cb) 
		              if (image[posy+0][posx+3] > cb) 
		               return true;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else if (image[posy+-1][posx+3] < c_b) 
		   if (image[posy+0][posx+3] < c_b)
		    if (image[posy+-2][posx+2] < c_b)
		     if (image[posy+-3][posx+1] < c_b)
		      if (image[posy+-3][posx+0] < c_b)
		       if (image[posy+-3][posx+-1] < c_b)
		        if (image[posy+-2][posx+-2] < c_b)
		         if (image[posy+-1][posx+-3] < c_b)
		          if (image[posy+0][posx+-3] < c_b)
		           if (image[posy+1][posx+3] < c_b)
		            if (image[posy+2][posx+2] < c_b)
		             return true;
		            else
		             if (image[posy+1][posx+-3] < c_b)
		              if (image[posy+2][posx+-2] < c_b)
		               return true;
		              else
		               return false;
		             else
		              return false;
		           else
		            if (image[posy+1][posx+-3] < c_b)
		             if (image[posy+2][posx+-2] < c_b)
		              if (image[posy+3][posx+-1] < c_b)
		               return true;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else
		   return false;
		 else
		  if (image[posy+-1][posx+3] > cb) 
		   if (image[posy+-2][posx+2] > cb) 
		    if (image[posy+-3][posx+1] > cb) 
		     if (image[posy+-3][posx+0] > cb) 
		      if (image[posy+-3][posx+-1] > cb) 
		       if (image[posy+-2][posx+-2] > cb) 
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             if (image[posy+1][posx+3] > cb) 
		              if (image[posy+0][posx+3] > cb) 
		               return true;
		              else
		               return false;
		             else
		              return false;
		           else
		            if (image[posy+2][posx+2] > cb) 
		             if (image[posy+1][posx+3] > cb) 
		              if (image[posy+0][posx+3] > cb) 
		               return true;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else if (image[posy+-1][posx+3] < c_b) 
		   if (image[posy+0][posx+3] < c_b)
		    if (image[posy+-2][posx+2] < c_b)
		     if (image[posy+-3][posx+1] < c_b)
		      if (image[posy+-3][posx+0] < c_b)
		       if (image[posy+-3][posx+-1] < c_b)
		        if (image[posy+-2][posx+-2] < c_b)
		         if (image[posy+-1][posx+-3] < c_b)
		          if (image[posy+0][posx+-3] < c_b)
		           if (image[posy+1][posx+-3] < c_b)
		            if (image[posy+1][posx+3] < c_b)
		             if (image[posy+2][posx+2] < c_b)
		              return true;
		             else
		              if (image[posy+2][posx+-2] < c_b)
		               return true;
		              else
		               return false;
		            else
		             if (image[posy+2][posx+-2] < c_b)
		              if (image[posy+3][posx+-1] < c_b)
		               return true;
		              else
		               return false;
		             else
		              return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else
		   return false;
		else if (image[posy+3][posx+0] < c_b) 
		 if (image[posy+3][posx+1] > cb) 
		  if (image[posy+-1][posx+3] > cb) 
		   if (image[posy+0][posx+3] > cb) 
		    if (image[posy+-2][posx+2] > cb) 
		     if (image[posy+-3][posx+1] > cb) 
		      if (image[posy+-3][posx+0] > cb) 
		       if (image[posy+-3][posx+-1] > cb) 
		        if (image[posy+-2][posx+-2] > cb) 
		         if (image[posy+-1][posx+-3] > cb) 
		          if (image[posy+0][posx+-3] > cb) 
		           if (image[posy+1][posx+3] > cb) 
		            if (image[posy+2][posx+2] > cb) 
		             return true;
		            else
		             if (image[posy+1][posx+-3] > cb) 
		              if (image[posy+2][posx+-2] > cb) 
		               return true;
		              else
		               return false;
		             else
		              return false;
		           else
		            if (image[posy+1][posx+-3] > cb) 
		             if (image[posy+2][posx+-2] > cb) 
		              if (image[posy+3][posx+-1] > cb) 
		               return true;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else if (image[posy+-1][posx+3] < c_b) 
		   if (image[posy+-2][posx+2] < c_b)
		    if (image[posy+-3][posx+1] < c_b)
		     if (image[posy+-3][posx+0] < c_b)
		      if (image[posy+-3][posx+-1] < c_b)
		       if (image[posy+-2][posx+-2] < c_b)
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             if (image[posy+1][posx+3] < c_b)
		              if (image[posy+0][posx+3] < c_b)
		               return true;
		              else
		               return false;
		             else
		              return false;
		           else
		            if (image[posy+2][posx+2] < c_b)
		             if (image[posy+1][posx+3] < c_b)
		              if (image[posy+0][posx+3] < c_b)
		               return true;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else
		   return false;
		 else if (image[posy+3][posx+1] < c_b) 
		  if (image[posy+2][posx+2] > cb) 
		   if (image[posy+-2][posx+2] > cb) 
		    if (image[posy+0][posx+3] > cb) 
		     if (image[posy+-1][posx+3] > cb) 
		      if (image[posy+-3][posx+1] > cb) 
		       if (image[posy+-3][posx+0] > cb) 
		        if (image[posy+-3][posx+-1] > cb) 
		         if (image[posy+-2][posx+-2] > cb) 
		          if (image[posy+-1][posx+-3] > cb) 
		           if (image[posy+0][posx+-3] > cb) 
		            if (image[posy+1][posx+-3] > cb) 
		             if (image[posy+1][posx+3] > cb) 
		              return true;
		             else
		              if (image[posy+2][posx+-2] > cb) 
		               if (image[posy+3][posx+-1] > cb) 
		                return true;
		               else
		                return false;
		              else
		               return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else if (image[posy+-2][posx+2] < c_b) 
		    if (image[posy+-3][posx+1] < c_b)
		     if (image[posy+-3][posx+0] < c_b)
		      if (image[posy+-3][posx+-1] < c_b)
		       if (image[posy+-2][posx+-2] < c_b)
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             if (image[posy+1][posx+3] < c_b)
		              if (image[posy+0][posx+3] < c_b)
		               if (image[posy+-1][posx+3] < c_b)
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else if (image[posy+2][posx+2] < c_b) 
		   if (image[posy+1][posx+3] > cb) 
		    if (image[posy+3][posx+-1] < c_b)
		     if (image[posy+-3][posx+1] > cb) 
		      if (image[posy+0][posx+3] > cb) 
		       if (image[posy+-1][posx+3] > cb) 
		        if (image[posy+-2][posx+2] > cb) 
		         if (image[posy+-3][posx+0] > cb) 
		          if (image[posy+-3][posx+-1] > cb) 
		           if (image[posy+-2][posx+-2] > cb) 
		            if (image[posy+-1][posx+-3] > cb) 
		             if (image[posy+0][posx+-3] > cb) 
		              if (image[posy+1][posx+-3] > cb) 
		               if (image[posy+2][posx+-2] > cb) 
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else if (image[posy+-3][posx+1] < c_b) 
		      if (image[posy+-3][posx+0] < c_b)
		       if (image[posy+-3][posx+-1] < c_b)
		        if (image[posy+-2][posx+-2] < c_b)
		         if (image[posy+-1][posx+-3] < c_b)
		          if (image[posy+0][posx+-3] < c_b)
		           if (image[posy+1][posx+-3] < c_b)
		            if (image[posy+2][posx+-2] < c_b)
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     if (image[posy+0][posx+3] > cb) 
		      if (image[posy+-1][posx+3] > cb) 
		       if (image[posy+-2][posx+2] > cb) 
		        if (image[posy+-3][posx+1] > cb) 
		         if (image[posy+-3][posx+0] > cb) 
		          if (image[posy+-3][posx+-1] > cb) 
		           if (image[posy+-2][posx+-2] > cb) 
		            if (image[posy+-1][posx+-3] > cb) 
		             if (image[posy+0][posx+-3] > cb) 
		              if (image[posy+1][posx+-3] > cb) 
		               if (image[posy+2][posx+-2] > cb) 
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		   else if (image[posy+1][posx+3] < c_b) 
		    if (image[posy+0][posx+3] > cb) 
		     if (image[posy+-3][posx+0] > cb) 
		      if (image[posy+-1][posx+3] > cb) 
		       if (image[posy+-2][posx+2] > cb) 
		        if (image[posy+-3][posx+1] > cb) 
		         if (image[posy+-3][posx+-1] > cb) 
		          if (image[posy+-2][posx+-2] > cb) 
		           if (image[posy+-1][posx+-3] > cb) 
		            if (image[posy+0][posx+-3] > cb) 
		             if (image[posy+1][posx+-3] > cb) 
		              if (image[posy+2][posx+-2] > cb) 
		               if (image[posy+3][posx+-1] > cb) 
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else if (image[posy+-3][posx+0] < c_b) 
		      if (image[posy+-3][posx+-1] < c_b)
		       if (image[posy+-2][posx+-2] < c_b)
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else if (image[posy+0][posx+3] < c_b) 
		     if (image[posy+-1][posx+3] < c_b)
		      if (image[posy+-2][posx+2] < c_b)
		       if (image[posy+-3][posx+1] < c_b)
		        if (image[posy+-3][posx+0] < c_b)
		         if (image[posy+-3][posx+-1] < c_b)
		          if (image[posy+-2][posx+-2] < c_b)
		           if (image[posy+-1][posx+-3] < c_b)
		            return true;
		           else
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             return false;
		          else
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             return false;
		           else
		            return false;
		         else
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		        else
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		       else
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		      else
		       if (image[posy+-2][posx+-2] < c_b)
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		     else
		      if (image[posy+-3][posx+-1] < c_b)
		       if (image[posy+-2][posx+-2] < c_b)
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		    else
		     if (image[posy+-3][posx+0] < c_b)
		      if (image[posy+-3][posx+-1] < c_b)
		       if (image[posy+-2][posx+-2] < c_b)
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		   else
		    if (image[posy+-3][posx+1] > cb) 
		     if (image[posy+0][posx+3] > cb) 
		      if (image[posy+-1][posx+3] > cb) 
		       if (image[posy+-2][posx+2] > cb) 
		        if (image[posy+-3][posx+0] > cb) 
		         if (image[posy+-3][posx+-1] > cb) 
		          if (image[posy+-2][posx+-2] > cb) 
		           if (image[posy+-1][posx+-3] > cb) 
		            if (image[posy+0][posx+-3] > cb) 
		             if (image[posy+1][posx+-3] > cb) 
		              if (image[posy+2][posx+-2] > cb) 
		               if (image[posy+3][posx+-1] > cb) 
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else if (image[posy+-3][posx+1] < c_b) 
		     if (image[posy+-3][posx+0] < c_b)
		      if (image[posy+-3][posx+-1] < c_b)
		       if (image[posy+-2][posx+-2] < c_b)
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		  else
		   if (image[posy+-2][posx+2] > cb) 
		    if (image[posy+0][posx+3] > cb) 
		     if (image[posy+-1][posx+3] > cb) 
		      if (image[posy+-3][posx+1] > cb) 
		       if (image[posy+-3][posx+0] > cb) 
		        if (image[posy+-3][posx+-1] > cb) 
		         if (image[posy+-2][posx+-2] > cb) 
		          if (image[posy+-1][posx+-3] > cb) 
		           if (image[posy+0][posx+-3] > cb) 
		            if (image[posy+1][posx+-3] > cb) 
		             if (image[posy+2][posx+-2] > cb) 
		              if (image[posy+1][posx+3] > cb) 
		               return true;
		              else
		               if (image[posy+3][posx+-1] > cb) 
		                return true;
		               else
		                return false;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else if (image[posy+-2][posx+2] < c_b) 
		    if (image[posy+-3][posx+1] < c_b)
		     if (image[posy+-3][posx+0] < c_b)
		      if (image[posy+-3][posx+-1] < c_b)
		       if (image[posy+-2][posx+-2] < c_b)
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             if (image[posy+1][posx+3] < c_b)
		              if (image[posy+0][posx+3] < c_b)
		               if (image[posy+-1][posx+3] < c_b)
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		 else
		  if (image[posy+-1][posx+3] > cb) 
		   if (image[posy+0][posx+3] > cb) 
		    if (image[posy+-2][posx+2] > cb) 
		     if (image[posy+-3][posx+1] > cb) 
		      if (image[posy+-3][posx+0] > cb) 
		       if (image[posy+-3][posx+-1] > cb) 
		        if (image[posy+-2][posx+-2] > cb) 
		         if (image[posy+-1][posx+-3] > cb) 
		          if (image[posy+0][posx+-3] > cb) 
		           if (image[posy+1][posx+-3] > cb) 
		            if (image[posy+1][posx+3] > cb) 
		             if (image[posy+2][posx+2] > cb) 
		              return true;
		             else
		              if (image[posy+2][posx+-2] > cb) 
		               return true;
		              else
		               return false;
		            else
		             if (image[posy+2][posx+-2] > cb) 
		              if (image[posy+3][posx+-1] > cb) 
		               return true;
		              else
		               return false;
		             else
		              return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else if (image[posy+-1][posx+3] < c_b) 
		   if (image[posy+-2][posx+2] < c_b)
		    if (image[posy+-3][posx+1] < c_b)
		     if (image[posy+-3][posx+0] < c_b)
		      if (image[posy+-3][posx+-1] < c_b)
		       if (image[posy+-2][posx+-2] < c_b)
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             if (image[posy+1][posx+3] < c_b)
		              if (image[posy+0][posx+3] < c_b)
		               return true;
		              else
		               return false;
		             else
		              return false;
		           else
		            if (image[posy+2][posx+2] < c_b)
		             if (image[posy+1][posx+3] < c_b)
		              if (image[posy+0][posx+3] < c_b)
		               return true;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else
		   return false;
		else
		 if (image[posy+0][posx+3] > cb) 
		  if (image[posy+-1][posx+3] > cb) 
		   if (image[posy+-2][posx+2] > cb) 
		    if (image[posy+-3][posx+1] > cb) 
		     if (image[posy+-3][posx+0] > cb) 
		      if (image[posy+-3][posx+-1] > cb) 
		       if (image[posy+-2][posx+-2] > cb) 
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+3] > cb) 
		           if (image[posy+2][posx+2] > cb) 
		            if (image[posy+3][posx+1] > cb) 
		             return true;
		            else
		             if (image[posy+1][posx+-3] > cb) 
		              return true;
		             else
		              return false;
		           else
		            if (image[posy+1][posx+-3] > cb) 
		             if (image[posy+2][posx+-2] > cb) 
		              return true;
		             else
		              return false;
		            else
		             return false;
		          else
		           if (image[posy+1][posx+-3] > cb) 
		            if (image[posy+2][posx+-2] > cb) 
		             if (image[posy+3][posx+-1] > cb) 
		              return true;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else
		   return false;
		 else if (image[posy+0][posx+3] < c_b) 
		  if (image[posy+-1][posx+3] < c_b)
		   if (image[posy+-2][posx+2] < c_b)
		    if (image[posy+-3][posx+1] < c_b)
		     if (image[posy+-3][posx+0] < c_b)
		      if (image[posy+-3][posx+-1] < c_b)
		       if (image[posy+-2][posx+-2] < c_b)
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+3] < c_b)
		           if (image[posy+2][posx+2] < c_b)
		            if (image[posy+3][posx+1] < c_b)
		             return true;
		            else
		             if (image[posy+1][posx+-3] < c_b)
		              return true;
		             else
		              return false;
		           else
		            if (image[posy+1][posx+-3] < c_b)
		             if (image[posy+2][posx+-2] < c_b)
		              return true;
		             else
		              return false;
		            else
		             return false;
		          else
		           if (image[posy+1][posx+-3] < c_b)
		            if (image[posy+2][posx+-2] < c_b)
		             if (image[posy+3][posx+-1] < c_b)
		              return true;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else
		   return false;
		 else
		  return false;
	}
	
	/**
	 * A non-maximum suppression algorithm.
	 * 
	 * @param w The width of the image.
	 * @param h The height of the image.
	 * @param features A list of FeaturePoint objects, most likely calculated with
	 *  			   one of the two detection functions.
	 *  
	 * @return Returns a list of FeaturePoint objects. Each object wraps a (x,y,score) tuple.
	 */
	private static List<FeaturePoint> nonMaxSuppression(int w, int h, List<FeaturePoint> features)
	{
		int[][] pixels = new int[h][w];
		List<FeaturePoint> nonMaxFeatures = new ArrayList<FeaturePoint>();
		for (int i = 0; i < features.size(); ++i) {
			FeaturePoint fp = features.get(i);
			pixels[fp.y()][fp.x()] = fp.score();
		}
		for (int i = 0; i < features.size(); ++i) {
			FeaturePoint fp = features.get(i);
			int y = fp.y();
			int x = fp.x();
			int score = fp.score();
			if (score >= pixels[y-1][x+1] && score >= pixels[y-1][x] &&
			    score >= pixels[y-1][x-1] && score >= pixels[y][x+1] && 
			    score >= pixels[y][x-1] && score >= pixels[y+1][x+1] && 
			    score >= pixels[y+1][x] && score >= pixels[y+1][x-1]) {
				nonMaxFeatures.add(fp);
			}
		}
		return nonMaxFeatures;
	}
}
