import mediapipe as mp
import cv2
import numpy as np
from facial_landmarks import FaceLandmarks

# load face landmarks

fl = FaceLandmarks()

cap = cv2.VideoCapture("wonyoung.mp4")

while True:

    ret, frame = cap.read()
    frame = cv2.resize(frame, (512, 512))
    frame_copy = frame.copy()

    height, width, _ = frame.shape

    # 1. face landmarks detection
    landmarks = fl.get_facial_landmarks(frame)

    convexhull = cv2.convexHull(landmarks)

    # 2. face blurring

    mask = np.zeros((height, width), np.uint8)

    #cv2.polylines(mask, [convexhull], True, 255, 3)
    cv2.fillConvexPoly(mask, convexhull, 255)

    # 3. Extract the face
    frame_copy = cv2.blur(frame_copy, (37, 37))
    face_extracted = cv2.bitwise_and(frame_copy, frame_copy, mask=mask)
    #blurred_face = cv2.GaussianBlur(face_extracted, (37, 37), 0)

    # 4. Extract background

    background_mask = cv2.bitwise_not(mask)
    background = cv2.bitwise_and(frame, frame, mask=background_mask)

    # final result
    result = cv2.add(background, face_extracted)

    #cv2.imshow("blurred face", frame_copy)
    cv2.imshow("result", result)

    key = cv2.waitKey(30)

    if key == 27:
        break

cap.release()
cv2.destroyAllWindows()
